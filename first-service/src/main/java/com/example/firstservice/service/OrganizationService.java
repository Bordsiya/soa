package com.example.firstservice.service;

import com.example.firstservice.entity.Address;
import com.example.firstservice.entity.Coordinates;
import com.example.firstservice.entity.Organization;
import com.example.firstservice.entity.OrganizationType;
import com.example.firstservice.exception.CoordinatesAlreadyReservedException;
import com.example.firstservice.exception.not_found.AddressNotFoundException;
import com.example.firstservice.exception.not_found.CoordinatesNotFoundException;
import com.example.firstservice.exception.not_found.OrganizationNotFoundException;
import com.example.firstservice.exception.not_found.OrganizationTypeNotFoundException;
import com.example.firstservice.models.AddressDTO;
import com.example.firstservice.models.AnnualTurnoverOrganizationsCountDTO;
import com.example.firstservice.models.OnlyAnnualTurnoverDTO;
import com.example.firstservice.models.OrganizationWithoutIdDTO;
import com.example.firstservice.repository.OrganizationRepository;
import com.example.firstservice.util.comparators.OrganizationComparator;
import com.example.firstservice.util.enums.SortingOrFilteringField;
import com.example.firstservice.util.mappers.CoordinatesMapper;
import com.example.firstservice.util.mappers.OrganizationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class OrganizationService {
    private OrganizationRepository organizationRepository;
    private OrganizationMapper organizationMapper;
    private AddressService addressService;
    private CoordinatesService coordinatesService;
    private OrganizationTypeService organizationTypeService;
    private CoordinatesMapper coordinatesMapper;

    @Autowired
    public OrganizationService(
            OrganizationRepository organizationRepository,
            OrganizationMapper organizationMapper,
            AddressService addressService,
            CoordinatesService coordinatesService,
            OrganizationTypeService organizationTypeService,
            CoordinatesMapper coordinatesMapper
    ) {
        this.organizationRepository = organizationRepository;
        this.organizationMapper = organizationMapper;
        this.addressService = addressService;
        this.coordinatesService = coordinatesService;
        this.organizationTypeService = organizationTypeService;
        this.coordinatesMapper = coordinatesMapper;
    }

    public Organization getOrganizationById(Integer organizationId) {
        return organizationRepository.findById(organizationId)
                .orElseThrow(() -> new OrganizationNotFoundException("organization-id", organizationId));
    }

    public Organization findOrganizationByAddressId(Integer addressId) {
        List<Organization> organizationList = organizationRepository.findOrganizationByAddress_Id(addressId);
        if (organizationList.isEmpty()) throw new OrganizationNotFoundException("organization-address-id", addressId);
        return organizationList.get(0);
    }

    public Organization addOrganization(OrganizationWithoutIdDTO organizationWithoutIdDTO) {
        try {
            Coordinates coordinates = coordinatesService.findCoordinatesByXAndY(
                    organizationWithoutIdDTO.getCoordinatesDTO().getX(),
                    organizationWithoutIdDTO.getCoordinatesDTO().getY()
            );
            throw new CoordinatesAlreadyReservedException(coordinates.getX(), coordinates.getY());
        } catch (CoordinatesNotFoundException ignored) {
        }

        OrganizationType organizationType;
        try {
            organizationType =
                    organizationTypeService.findOrganizationTypeByType(organizationWithoutIdDTO.getType().name());
        } catch (OrganizationTypeNotFoundException e) {
            organizationType = organizationTypeService.addOrganizationType(organizationWithoutIdDTO.getType());
        }

        Address address;
        try {
            address = addressService.findAddressByStreetAndZipCode(
                    organizationWithoutIdDTO.getOfficialAddressDTO().getStreet(),
                    organizationWithoutIdDTO.getOfficialAddressDTO().getZipCode()
            );
        } catch (AddressNotFoundException e) {
            address = addressService.addAddress(organizationWithoutIdDTO.getOfficialAddressDTO());
        }

        Organization organization = organizationMapper.fromDTO(organizationWithoutIdDTO);
        organization.setOrganizationType(organizationType);
        organization.setAddress(address);
        return organizationRepository.save(organization);
    }

    public void deleteOrganizationById(Integer id) {
        getOrganizationById(id);
        organizationRepository.deleteById(id);
    }

    public void deleteOrganizationByOfficialAddress(AddressDTO addressDTO) {
        Address foundAddress = addressService.findAddressByStreetAndZipCode(
                addressDTO.getStreet(), addressDTO.getZipCode()
        );
        Organization organization = findOrganizationByAddressId(foundAddress.getId());
        organizationRepository.deleteById(organization.getId());

        if (foundAddress.getOrganizations().isEmpty()) addressService.deleteAddress(foundAddress.getId());
    }

    public Organization updateOrganizationById(Integer id, OrganizationWithoutIdDTO body) {
        Organization organization = getOrganizationById(id);
        organization.setName(body.getName());

        try {
            Coordinates coordinates = coordinatesService.findCoordinatesByXAndY(
                    body.getCoordinatesDTO().getX(), body.getCoordinatesDTO().getY());
            throw new CoordinatesAlreadyReservedException(coordinates.getX(), coordinates.getY());
        } catch (CoordinatesNotFoundException e) {
            coordinatesService.updateCoordinates(organization.getCoordinates().getId(), body.getCoordinatesDTO());
        }

        organization.setCreationDate(Timestamp.valueOf(body.getCreationDate().atStartOfDay()));
        organization.setAnnualTurnover(body.getAnnualTurnover());

        OrganizationType organizationType;
        try {
            organizationType =
                    organizationTypeService.findOrganizationTypeByType(body.getType().name());
        } catch (OrganizationTypeNotFoundException e) {
            organizationType = organizationTypeService.addOrganizationType(body.getType());
        }
        organization.setOrganizationType(organizationType);

        Address address;
        try {
            address = addressService.findAddressByStreetAndZipCode(
                    body.getOfficialAddressDTO().getStreet(),
                    body.getOfficialAddressDTO().getZipCode()
            );
        } catch (AddressNotFoundException e) {
            address = addressService.addAddress(body.getOfficialAddressDTO());
        }
        organization.setAddress(address);
        return organizationRepository.save(organization);
    }

    public OnlyAnnualTurnoverDTO getSumOfOrganizationsAnnualTurnovers() {
        return new OnlyAnnualTurnoverDTO(organizationRepository.getSumOfOrganizationsAnnualTurnovers());
    }

    public List<AnnualTurnoverOrganizationsCountDTO> getGroupedOrganizationsByAnnualTurnover() {
        return organizationRepository.getGroupedOrganizationsByAnnualTurnover();
    }

    public List<Organization> getOrganizationsWithPreferences(List<String> fieldsForSort) {
        List<Organization> organizations = organizationRepository.findAll();

        //filtering


        // sorting
        if (fieldsForSort != null) {
            List<SortingOrFilteringField> sortingFields = fieldsForSort.stream()
                    .map(SortingOrFilteringField::fromValue)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
            sortOrganizationsByField(organizations, sortingFields);
        }

        return organizations;
    }

    public void sortOrganizationsByField(List<Organization> organizations, List<SortingOrFilteringField> sortFields) {
        Comparator<Organization> multiComparator = null;
        for (SortingOrFilteringField sortField : sortFields) {
            if (multiComparator == null) {
                multiComparator = OrganizationComparator.findComparatorByFieldName(sortField);
            } else {
                multiComparator.thenComparing(OrganizationComparator.findComparatorByFieldName(sortField));
            }
        }

        if (multiComparator != null) {
            organizations.sort(multiComparator);
        }
    }
}

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
import com.example.firstservice.models.*;
import com.example.firstservice.repository.OrganizationRepository;
import com.example.firstservice.util.comparators.OrganizationComparator;
import com.example.firstservice.util.enums.Quarter;
import com.example.firstservice.util.enums.SortingOrFilteringField;
import com.example.firstservice.util.filters.OrganizationFilter;
import com.example.firstservice.util.filters.OrganizationFilterService;
import com.example.firstservice.util.mappers.CoordinatesMapper;
import com.example.firstservice.util.mappers.OrganizationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public List<Organization> getOrganizationsWithPreferences(List<String> fieldsForSort, List<String> filterConditions) {
        List<Organization> organizations = organizationRepository.findAll();

        //filtering
        List<Organization> filteringOrganizations = organizations;
        if (filterConditions != null) {
            List<OrganizationFilter> filters = OrganizationFilterService.parseFilters(filterConditions);
            filteringOrganizations = new ArrayList<>();
            for (Organization org : organizations) {
                if (OrganizationFilterService.applyFilters(org, filters)) {
                    filteringOrganizations.add(org);
                }
            }
        }

        // sorting
        if (fieldsForSort != null) {
            List<SortingOrFilteringField> sortingFields = fieldsForSort.stream()
                    .map(SortingOrFilteringField::fromValue)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
            sortOrganizationsByField(filteringOrganizations, sortingFields);
        }

        return filteringOrganizations;
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

    public PredictionDTO predictOrganizationAnnualTurnoverBehavior(Integer id) {
        double increaseProbability = 0.9D;
        double decreaseProbability = 0D;

        final double AGE = 10;
        final double COMPETITIVE_AMOUNT = 3;

        Organization organization = getOrganizationById(id);
        List<Integer> competitiveOrganizationsIdsNear = organizationRepository.findCompetitiveOrganizationsIds(
                id,
                organization.getCoordinates().getX(),
                organization.getCoordinates().getY(),
                organization.getAnnualTurnover(),
                organization.getEmployees().size()
        );
        long amountOfCompetitiveOrganizationsTheSameTypeNear = competitiveOrganizationsIdsNear
                .stream().filter(
                        orgId -> getOrganizationById(orgId).getOrganizationType().equals(organization.getOrganizationType()))
                .count();
        if (amountOfCompetitiveOrganizationsTheSameTypeNear > COMPETITIVE_AMOUNT) {
            increaseProbability -= 0.3D;
            decreaseProbability += 0.3D;
        }
        else if (amountOfCompetitiveOrganizationsTheSameTypeNear == COMPETITIVE_AMOUNT) {
            increaseProbability -= 0.2D;
        }

        Quarter quarter = Quarter.fromCoordinates(
                organization.getCoordinates().getX(), organization.getCoordinates().getY());
        List<Long> quartersWithAmounts = coordinatesService.getAmountOfOrganizationsForEachCoordinateQuarter();
        int minInd = IntStream.range(0, quartersWithAmounts.size())
                .reduce((i,j) -> quartersWithAmounts.get(i)
                        > quartersWithAmounts.get(j) ? j : i)
                .getAsInt();
        int maxInd = IntStream.range(0, quartersWithAmounts.size())
                .reduce((i,j) -> quartersWithAmounts.get(i) < quartersWithAmounts.get(j) ? j : i)
                .getAsInt();
        if (Quarter.toNumber(quarter) == maxInd) {
            decreaseProbability += 0.3D;
            increaseProbability -= 0.3D;
        }
        else if (Quarter.toNumber(quarter) != minInd) {
            increaseProbability -= 0.2D;
        }

        long organizationAge = ChronoUnit.YEARS.between(
                organization.getCreationDate().toLocalDateTime(),
                LocalDateTime.now()
        );
        if (organizationAge > AGE) {
            increaseProbability -= 0.1D;
            if (decreaseProbability >= 0.3D) decreaseProbability -= 0.3D;
        }

        return new PredictionDTO(
                BigDecimal.valueOf(increaseProbability)
                        .setScale(3, RoundingMode.HALF_UP).doubleValue(),
                BigDecimal.valueOf(decreaseProbability)
                        .setScale(3, RoundingMode.HALF_UP).doubleValue(),
                BigDecimal.valueOf(1D - (Double.max(increaseProbability, decreaseProbability)
                        + Double.min(increaseProbability, decreaseProbability)))
                        .setScale(3, RoundingMode.HALF_DOWN).doubleValue()
        );
    }

    public List<Organization> recommendOrganizationsByCoordinates(Double x, Long y) {
        final double ANNUAL_TURNOVER_MIN = 700000D;
        final int EMPLOYEES_COUNT_MIN = 3;

        List<Integer> recommendedOrganizations = organizationRepository.findCompetitiveOrganizationsIds(
                0,
                x,
                y,
                ANNUAL_TURNOVER_MIN,
                EMPLOYEES_COUNT_MIN
        );
        return recommendedOrganizations.stream().map(this::getOrganizationById).toList();
    }
}

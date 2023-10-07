package com.example.firstservice.util.mappers;

import com.example.firstservice.entity.Address;
import com.example.firstservice.entity.Coordinates;
import com.example.firstservice.entity.Organization;
import com.example.firstservice.entity.OrganizationType;
import com.example.commonservice.model.AddressDTO;
import com.example.commonservice.model.CoordinatesDTO;
import com.example.commonservice.model.OrganizationDTO;
import com.example.commonservice.model.OrganizationWithoutIdDTO;
import com.example.commonservice.enums.OrganizationTypeDto;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrganizationMapper {
    public Organization fromDTO(OrganizationWithoutIdDTO organizationWithoutIdDTO) {
        return new Organization(
                0,
                organizationWithoutIdDTO.getName(),
                new Coordinates(
                        0,
                        organizationWithoutIdDTO.getCoordinatesDTO().getX(),
                        organizationWithoutIdDTO.getCoordinatesDTO().getY(),
                        null
                ),
                Timestamp.valueOf(organizationWithoutIdDTO.getCreationDate().atStartOfDay()),
                organizationWithoutIdDTO.getAnnualTurnover(),
                new OrganizationType(
                        0,
                        organizationWithoutIdDTO.getType().name(),
                        new ArrayList<>()
                ),
                new Address(
                        0,
                        organizationWithoutIdDTO.getOfficialAddressDTO().getStreet(),
                        organizationWithoutIdDTO.getOfficialAddressDTO().getZipCode(),
                        new ArrayList<>()
                ),
                new ArrayList<>()
        );
    }

    public OrganizationDTO toDTO(Organization organization){
        return new OrganizationDTO(
                organization.getId(),
                organization.getName(),
                new CoordinatesDTO(
                        organization.getCoordinates().getX(),
                        organization.getCoordinates().getY()
                ),
                organization.getCreationDate().toLocalDateTime().toLocalDate(),
                organization.getAnnualTurnover(),
                OrganizationTypeDto.fromValue(organization.getOrganizationType().getType()),
                new AddressDTO(
                        organization.getAddress().getStreet(),
                        organization.getAddress().getZipCode()
                )
        );
    }

    public List<OrganizationDTO> toDTO(List<Organization> organizations) {
        return organizations.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}

package com.example.firstservice.util.mappers;

import com.example.firstservice.entity.OrganizationType;
import com.example.firstservice.util.enums.OrganizationTypeDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrganizationTypeMapper {
    public OrganizationType fromDTO(OrganizationTypeDto organizationTypeDto) {
        return new OrganizationType(
                0,
                organizationTypeDto.name(),
                List.of()
        );
    }
}

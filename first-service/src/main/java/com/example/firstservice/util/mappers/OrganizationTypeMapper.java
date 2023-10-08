package com.example.firstservice.util.mappers;

import com.example.firstservice.entity.OrganizationType;
import com.example.commonservice.enums.OrganizationTypeDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrganizationTypeMapper {
    public OrganizationType fromDTO(OrganizationTypeDto organizationTypeDto) {
        return new OrganizationType(
                0,
                organizationTypeDto.name(),
                new ArrayList<>()
        );
    }
}

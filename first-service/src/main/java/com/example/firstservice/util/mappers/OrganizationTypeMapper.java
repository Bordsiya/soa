package com.example.firstservice.util.mappers;

import com.example.firstservice.entity.OrganizationType;
import com.example.firstservice.util.enums.OrganizationTypeType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrganizationTypeMapper {
    public OrganizationType fromDTO(OrganizationTypeType organizationTypeType) {
        return new OrganizationType(
                0,
                organizationTypeType.name(),
                List.of()
        );
    }
}

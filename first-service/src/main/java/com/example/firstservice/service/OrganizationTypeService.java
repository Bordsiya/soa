package com.example.firstservice.service;

import com.example.firstservice.entity.OrganizationType;
import com.example.firstservice.exception.not_found.OrganizationTypeNotFoundException;
import com.example.firstservice.repository.OrganizationTypeRepository;
import com.example.firstservice.util.mappers.OrganizationTypeMapper;
import com.example.firstservice.util.enums.OrganizationTypeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizationTypeService {

    private OrganizationTypeRepository organizationTypeRepository;
    private OrganizationTypeMapper organizationTypeMapper;

    @Autowired
    public OrganizationTypeService(
            OrganizationTypeRepository organizationTypeRepository,
            OrganizationTypeMapper organizationTypeMapper
    ) {
        this.organizationTypeRepository = organizationTypeRepository;
        this.organizationTypeMapper = organizationTypeMapper;
    }

    public OrganizationType getOrganizationTypeById(Integer organizationTypeId) {
        return organizationTypeRepository.findById(organizationTypeId)
                .orElseThrow(() -> new OrganizationTypeNotFoundException(organizationTypeId));
    }

    public OrganizationType findOrganizationTypeByType(String type) {
        OrganizationType organizationType = organizationTypeRepository.findOrganizationTypeByType(type);
        if (organizationType == null) throw new OrganizationTypeNotFoundException(type);
        return organizationType;
    }

    public OrganizationType addOrganizationType(OrganizationTypeDto organizationTypeDto) {
        return organizationTypeRepository.save(organizationTypeMapper.fromDTO(organizationTypeDto));
    }
}

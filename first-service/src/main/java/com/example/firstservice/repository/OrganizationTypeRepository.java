package com.example.firstservice.repository;

import com.example.firstservice.entity.OrganizationType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationTypeRepository extends JpaRepository<OrganizationType, Integer> {
    OrganizationType findOrganizationTypeByType(String typeName);
}

package com.example.firstservice.exception.not_found;

import com.example.commonservice.exception.not_found.ResourceNotFoundException;
public class OrganizationTypeNotFoundException extends ResourceNotFoundException {
    public OrganizationTypeNotFoundException(Integer organizationTypeId) {
        super("OrganizationType", "organization-type-id", organizationTypeId.toString());
    }

    public OrganizationTypeNotFoundException(String type) {
        super("OrganizationType", "organization-type-type", type);
    }
}

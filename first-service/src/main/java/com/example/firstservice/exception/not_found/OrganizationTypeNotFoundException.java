package com.example.firstservice.exception.not_found;

public class OrganizationTypeNotFoundException extends ResourceNotFoundException {
    public OrganizationTypeNotFoundException(Integer organizationTypeId) {
        super("OrganizationType", "organization-type-id", organizationTypeId.toString());
    }

    public OrganizationTypeNotFoundException(String type) {
        super("OrganizationType", "organization-type-type", type);
    }
}

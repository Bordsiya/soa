package com.example.firstservice.exception.not_found;

public class OrganizationNotFoundException extends ResourceNotFoundException {
    public OrganizationNotFoundException(String nameId, Integer id) {
        super("Organization", nameId, id.toString());
    }
}

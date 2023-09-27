package com.example.firstservice.exception.not_found;

import com.example.commonservice.exception.not_found.ResourceNotFoundException;
public class OrganizationNotFoundException extends ResourceNotFoundException {
    public OrganizationNotFoundException(String nameId, Integer id) {
        super("Organization", nameId, id.toString());
    }
}

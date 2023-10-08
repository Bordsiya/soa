package com.example.commonservice.exception;

public class UndefinedOrganizationTypeException extends RuntimeException {
    public UndefinedOrganizationTypeException() {
        super("OrganizationType is not supported");
    }
}

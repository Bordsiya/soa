package org.example.models.exception;

public class UndefinedOrganizationTypeException extends RuntimeException {
    public UndefinedOrganizationTypeException() {
        super("OrganizationType is not supported");
    }
}

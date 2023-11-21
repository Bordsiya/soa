package org.example.ejb.exception;

public class UndefinedOrganizationTypeException extends RuntimeException {
    public UndefinedOrganizationTypeException() {
        super("OrganizationType is not supported");
    }
}

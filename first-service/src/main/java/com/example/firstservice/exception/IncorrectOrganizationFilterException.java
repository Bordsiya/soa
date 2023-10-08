package com.example.firstservice.exception;

public class IncorrectOrganizationFilterException extends RuntimeException {
    public IncorrectOrganizationFilterException(String filterString) {
        super("can't parse this filter condition: " + filterString);
    }
}

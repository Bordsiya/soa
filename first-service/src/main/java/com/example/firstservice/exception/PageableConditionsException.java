package com.example.firstservice.exception;

public class PageableConditionsException extends RuntimeException {
    public PageableConditionsException() {
        super("Error with pageSize and pageNumber. There's no so much objects.");
    }
}

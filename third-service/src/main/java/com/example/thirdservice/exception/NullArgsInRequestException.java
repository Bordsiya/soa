package com.example.thirdservice.exception;

import javax.ws.rs.WebApplicationException;

public class NullArgsInRequestException extends WebApplicationException {
    public NullArgsInRequestException(String arg) {
        super(String.format("Null args were sent [%s]", arg));
    }
}

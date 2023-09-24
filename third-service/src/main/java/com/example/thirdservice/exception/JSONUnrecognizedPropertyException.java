package com.example.thirdservice.exception;

import javax.ws.rs.WebApplicationException;

public class JSONUnrecognizedPropertyException extends WebApplicationException {

    public JSONUnrecognizedPropertyException() {
        super("Неидентифицированное поле в JSON");
    }
}

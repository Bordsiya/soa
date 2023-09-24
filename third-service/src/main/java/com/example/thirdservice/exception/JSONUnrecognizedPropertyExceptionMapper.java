package com.example.thirdservice.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class JSONUnrecognizedPropertyExceptionMapper implements ExceptionMapper<JSONUnrecognizedPropertyException> {
    @Override
    public Response toResponse(JSONUnrecognizedPropertyException e) {
        return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
    }
}

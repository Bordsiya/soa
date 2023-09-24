package com.example.thirdservice.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NullArgsInRequestExceptionMapper implements ExceptionMapper<NullArgsInRequestException> {
    @Override
    public Response toResponse(NullArgsInRequestException e) {
        return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
    }
}

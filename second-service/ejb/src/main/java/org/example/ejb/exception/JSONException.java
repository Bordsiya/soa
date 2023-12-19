package org.example.ejb.exception;

import org.example.ejb.model.ErrorDTO;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;

public class JSONException extends WebApplicationException {
    public JSONException(String message) {
        super(Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(
                        new ErrorDTO("500", "JSON processing error because of:\n" + message, LocalDateTime.now())
                ).type(MediaType.APPLICATION_JSON).build());
    }
}

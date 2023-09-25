package com.example.secondservice.exception;

import com.example.firstservice.exception.*;
import com.example.firstservice.exception.not_found.ResourceNotFoundException;
import com.example.firstservice.models.ErrorDTO;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestClientException;

import java.time.LocalDateTime;
import java.util.regex.Pattern;

@ControllerAdvice
@ResponseBody
public class OrgdirectoryErrorHandler {
    @ExceptionHandler(RestClientException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDTO handleRestClientException(RestClientException ex) {
        ErrorDTO errorDTO = new ErrorDTO(
                HttpStatus.INTERNAL_SERVER_ERROR.name(), "Cannot connect to Organizations Service", LocalDateTime.now());
        return errorDTO;
    }
}

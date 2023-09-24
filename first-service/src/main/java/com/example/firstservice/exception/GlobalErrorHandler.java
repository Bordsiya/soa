package com.example.firstservice.exception;

import com.example.firstservice.exception.not_found.ResourceNotFoundException;
import com.example.firstservice.models.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ControllerAdvice
@ResponseBody
public class GlobalErrorHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorDTO handleNotFoundException(ResourceNotFoundException ex) {
        ErrorDTO errorDTO = new ErrorDTO(
                HttpStatus.NOT_FOUND.name(), ex.getMessage(), LocalDateTime.now());
        return errorDTO;
    }

    @ExceptionHandler(CoordinatesAlreadyReservedException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorDTO handleCoordinatesAlreadyReservedException(CoordinatesAlreadyReservedException ex) {
        ErrorDTO errorDTO = new ErrorDTO(
                HttpStatus.BAD_REQUEST.name(), ex.getMessage(), LocalDateTime.now());
        return errorDTO;
    }

    @ExceptionHandler(UndefinedOrganizationTypeException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorDTO handleUndefinedOrganizationTypeException(UndefinedOrganizationTypeException ex) {
        ErrorDTO errorDTO = new ErrorDTO(
                HttpStatus.BAD_REQUEST.name(), ex.getMessage(), LocalDateTime.now());
        return errorDTO;
    }
}

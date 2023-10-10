package com.example.firstservice.exception;

import com.example.commonservice.model.ErrorDTO;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ControllerAdvice
@Slf4j
@ResponseBody
public class JSONErrorHandler {

    @ExceptionHandler(UnrecognizedPropertyException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorDTO handleUnrecognizedPropertyException(UnrecognizedPropertyException ex) {
        log.error("catched error: " + ex.getMessage() + " " + ex.toString());
        ErrorDTO errorDTO = new ErrorDTO(
                HttpStatus.BAD_REQUEST.name(), "Unidentified JSON field", LocalDateTime.now());
        return errorDTO;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorDTO handleJsonException(Exception ex) {
        log.error("catched error: " + ex.getMessage() + " " + ex.toString());
        ErrorDTO errorDTO = new ErrorDTO(
                HttpStatus.BAD_REQUEST.name(), ex.getMessage(), LocalDateTime.now());
        return errorDTO;
    }
}

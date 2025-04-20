package com.java.springboot.getting_started.rest_api.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponse;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.java.springboot.getting_started.rest_api.models.exceptions.ExceptionWrapper;

@ControllerAdvice
public class ExceptionsManager {
    @ExceptionHandler(value = ErrorResponseException.class)
    public ErrorResponseException handlErrorResponseException(ErrorResponseException ex) {
        return new ExceptionWrapper(ex);
    }

    @ExceptionHandler(value = Exception.class)
    public ErrorResponseException handleGeneralExceptions(Exception ex) {
        if (ex instanceof ErrorResponse) {
            return new ExceptionWrapper((ErrorResponse) ex);
        }

        return new ExceptionWrapper(ex);
    }
}

package com.java.springboot.getting_started.rest_api.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.java.springboot.getting_started.rest_api.models.exceptions.ExceptionWrapper;

@ControllerAdvice
public class ExceptionsManager {
    @ExceptionHandler(value = HttpClientErrorException.class)
    public ErrorResponseException handleHttpClientErrorException(HttpClientErrorException ex) {
        return new ExceptionWrapper(ProblemDetail.forStatusAndDetail(ex.getStatusCode(), ex.getMessage()), ex);
    }

    @ExceptionHandler(value = ErrorResponseException.class)
    public ErrorResponseException handlErrorResponseException(ErrorResponseException ex) {
        return ex;
    }

    // handle general exceptions
    @ExceptionHandler(value = Exception.class)
    public ErrorResponseException handleNormalExceptions(Exception ex) {
        return new ExceptionWrapper(ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage()), ex);
    }

    @ExceptionHandler(value = NoResourceFoundException.class)
    public ErrorResponseException handleNoResourceFoundException(NoResourceFoundException ex) {
        return new ExceptionWrapper(ProblemDetail.forStatusAndDetail(ex.getStatusCode(), ex.getMessage()), ex);
    }
}

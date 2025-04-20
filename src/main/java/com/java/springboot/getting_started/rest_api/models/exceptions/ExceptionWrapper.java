package com.java.springboot.getting_started.rest_api.models.exceptions;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.ErrorResponse;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import jakarta.servlet.ServletException;

public class ExceptionWrapper extends BaseException {
    public ExceptionWrapper(HttpStatusCode status) {
        super(status);
    }

    public ExceptionWrapper(ErrorResponseException ex) {
        super(ex.getStatusCode());
        this.getBody().setProperties(ex.getBody().getProperties());
    }

    public ExceptionWrapper(HttpClientErrorException ex) {
        super(ex.getStatusCode());
        this.getBody().setProperty("errorType", ex.getClass().getSimpleName());
        this.getBody().setProperty("errorMessage", ex.getMessage());
    }

    public ExceptionWrapper(ErrorResponse ex) {
        super(ex.getStatusCode());
        this.getBody().setProperty("errorType", ex.getClass().getSimpleName());

        if (ex instanceof Exception) {
            this.getBody().setProperty("errorMessage", ((ServletException) ex).getMessage());
            return;
        }

        this.getBody().setProperty("errorMessage", "No error message was appended");
    }

    // Default exception to be returned
    public ExceptionWrapper(Exception ex) {
        super(HttpStatusCode.valueOf(500));
        
        this.getBody().setProperty("errorType", ex.getClass().getSimpleName());
        this.getBody().setProperty("errorMessage", ex.getMessage());
    }
}

package com.java.springboot.getting_started.rest_api.models.exceptions;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.ErrorResponseException;

public class ExceptionWrapper extends BaseException {
    public ExceptionWrapper(HttpStatusCode status) {
        super(status);
    }

    public ExceptionWrapper(ErrorResponseException ex) {
        super(ex.getStatusCode());
        this.getBody().setProperties(ex.getBody().getProperties());
    }

    // Default exception to be returned
    public ExceptionWrapper(Exception ex) {
        super(HttpStatusCode.valueOf(500));
        this.getBody().setProperty("errorType", ex.getClass().getSimpleName());
        this.getBody().setProperty("errorMessage", ex.getMessage());
    }
}

package com.java.springboot.getting_started.rest_api.models.exceptions;

import org.springframework.http.HttpStatusCode;
public class InvalidInputException extends BaseException {

    public InvalidInputException(HttpStatusCode status) {
        super(status);
        this.getBody().setProperty("errorType", this.getClass().getSimpleName());
        this.getBody().setProperty("errorMessage", "Invalid Input");
    }
}

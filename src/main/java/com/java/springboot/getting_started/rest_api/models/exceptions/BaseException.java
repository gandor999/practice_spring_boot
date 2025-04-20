package com.java.springboot.getting_started.rest_api.models.exceptions;

import java.net.URI;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponseException;

public class BaseException extends ErrorResponseException {

    public BaseException(HttpStatusCode status) {
        super(status);
        ProblemDetail body = this.getBody();
        body.setDetail("");
        body.setInstance(URI.create(""));
        body.setTitle("");
        body.setType(URI.create(""));
    }
}

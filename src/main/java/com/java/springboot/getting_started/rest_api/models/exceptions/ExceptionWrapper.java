package com.java.springboot.getting_started.rest_api.models.exceptions;

import java.net.URI;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponseException;

import io.micrometer.common.lang.Nullable;

public class ExceptionWrapper extends ErrorResponseException {
    public ExceptionWrapper(ProblemDetail problem, @Nullable Throwable cause) {
        super(HttpStatusCode.valueOf(problem.getStatus()), problem, cause);
        if (cause != null) {
            setType(URI.create(cause.getClass().getName()));
        } else {
            setType(URI.create(""));
        }
    }
}

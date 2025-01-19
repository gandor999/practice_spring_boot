package com.java.springboot.getting_started.rest_api.models.exceptions;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponseException;

import io.micrometer.common.lang.Nullable;

public class ExceptionWrapper extends ErrorResponseException {
    public ExceptionWrapper(ProblemDetail problem, @Nullable Throwable cause) {
        super(HttpStatusCode.valueOf(problem.getStatus()), problem, cause);

        // if (errorInformation == null) {

        // this.setType(new URI("no information written yet to resolve this error"));
        // }
    }
}

package com.java.springboot.getting_started.rest_api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@RestController
public class ExceptionsMap {
    @GetMapping("/sample_internal_error")
    public void sampleInternalError() throws Exception {
        throw new Exception(
                "normal custom exception, example: something happened during runtime in server | this is a pretty generalized error");
    }

    @GetMapping("/sample_http_error")
    public void sampleHttpError() throws HttpClientErrorException {
        throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR, "custom exception");
    }
}

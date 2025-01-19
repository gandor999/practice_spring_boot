package com.java.springboot.getting_started.rest_api.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.java.springboot.getting_started.rest_api.models.data_objects.Records.Greeting;

@RestController
public class GreetingController {
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name){
        throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR, "custom exception");
        // return new Greeting(counter.incrementAndGet(), "Hello " + name);
    }
}

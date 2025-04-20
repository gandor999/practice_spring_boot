package com.java.springboot.getting_started.rest_api.models.interfaces.request;

import org.springframework.http.HttpStatusCode;

import com.java.springboot.getting_started.rest_api.models.exceptions.InvalidInputException;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TestRequest extends BaseRequest {
    private String testProp;

    @Override
    public void validate() {
        if (testProp == null || testProp.isEmpty() || testProp.isBlank()) {
            throw new InvalidInputException(HttpStatusCode.valueOf(400));
        }
    }
}

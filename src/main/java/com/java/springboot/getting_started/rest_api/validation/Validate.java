package com.java.springboot.getting_started.rest_api.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Validate {}


@Aspect
@Component
class ValidateAspect {
    @Before("@annotation(validate)")
    public void validateRequest(JoinPoint joinPoint, Validate validate) {
        Object[] args = joinPoint.getArgs();

        for (Object arg : args) {
            if (arg instanceof IValidator) {
                ((IValidator) arg).validate(); // your custom validation
            }
        }
    }
}
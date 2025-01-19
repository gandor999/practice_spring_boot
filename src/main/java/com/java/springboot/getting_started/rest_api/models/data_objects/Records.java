package com.java.springboot.getting_started.rest_api.models.data_objects;

public class Records {
    public static record Greeting(long count, String content) {}
}

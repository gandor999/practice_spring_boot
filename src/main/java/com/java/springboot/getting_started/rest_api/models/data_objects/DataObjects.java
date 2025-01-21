package com.java.springboot.getting_started.rest_api.models.data_objects;

public class DataObjects {
    public static record Greeting(long count, String content) {
    }

    public static record StoreProduct(long productId, String description, int inventoryCount, float price) {
    }
}

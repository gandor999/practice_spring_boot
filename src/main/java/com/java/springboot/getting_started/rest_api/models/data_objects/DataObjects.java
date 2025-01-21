package com.java.springboot.getting_started.rest_api.models.data_objects;

import java.util.UUID;

public class DataObjects {
    public static record Greeting(long count, String content) {
    }

    public static record StoreProduct(UUID productId, String description, int inventoryCount, float price,
            String productName) {
    }
}

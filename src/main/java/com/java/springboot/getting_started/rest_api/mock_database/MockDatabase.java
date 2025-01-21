package com.java.springboot.getting_started.rest_api.mock_database;

import java.util.List;
import java.util.UUID;

import com.java.springboot.getting_started.rest_api.models.data_objects.DataObjects.StoreProduct;

public class MockDatabase {
    private List<StoreProduct> storeProducts = null;
    private static MockDatabase thisInstance = null;

    public MockDatabase() {
        storeProducts.add(new StoreProduct(UUID.randomUUID(), "sample store product", 10, 1000, "Product 1"));
        storeProducts.add(new StoreProduct(UUID.randomUUID(), "sample store product", 5, 900, "Product 2"));
    }

    public static MockDatabase getInstance() {
        if (thisInstance != null) {
            return thisInstance;
        }

        thisInstance = new MockDatabase();

        return thisInstance;
    }

    public StoreProduct[] getStoreProducts() {
        return (StoreProduct[]) storeProducts.toArray();
    }

    public StoreProduct addStoreProduct(StoreProduct newStoreProduct) {
        storeProducts.add(newStoreProduct);

        return newStoreProduct;
    }

    public StoreProduct removeStoreProduct(UUID productId) {
        StoreProduct removedStoreProduct = null;

        for (StoreProduct storeProduct : storeProducts) {
            if (storeProduct.productId().equals(productId)) {
                storeProducts.remove(storeProduct);
            }
        }

        return removedStoreProduct;
    }
}

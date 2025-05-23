package com.java.springboot.getting_started.rest_api.mock_database;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.java.springboot.getting_started.rest_api.models.data_objects.DataObjects.StoreProduct;

// @Component
public class MockDatabase {
    private List<StoreProduct> storeProducts = new ArrayList<>();
    private static final MockDatabase thisInstance = new MockDatabase();;

    public MockDatabase() {
        storeProducts.add(new StoreProduct(UUID.randomUUID(), "sample store product", 10, 1000, "Product 1"));
        storeProducts.add(new StoreProduct(UUID.randomUUID(), "sample store product", 5, 900, "Product 2"));
    }

    public static MockDatabase getInstance() {
        return thisInstance;
    }

    public StoreProduct[] getStoreProducts() {
        return storeProducts.toArray(new StoreProduct[0]);
    }

    public StoreProduct addStoreProduct(StoreProduct newStoreProduct) {
        storeProducts.add(newStoreProduct);

        return newStoreProduct;
    }

    public StoreProduct updateStoreProduct(UUID id, StoreProduct newStoreProduct) {
        int indexOfProduct = 0;

        for (int i = 0; i < storeProducts.size(); i++) {
            if (storeProducts.get(i).productId().equals(id)) {
                indexOfProduct = i;
                break;
            }
        }

        storeProducts.set(indexOfProduct, new StoreProduct(id, newStoreProduct.description(),
                newStoreProduct.inventoryCount(), newStoreProduct.price(), newStoreProduct.productName()));

        return storeProducts.get(indexOfProduct);
    }

    public StoreProduct removeStoreProduct(UUID productId) {
        StoreProduct removedStoreProduct = null;

        for (StoreProduct storeProduct : storeProducts) {
            if (storeProduct.productId().equals(productId)) {
                storeProducts.remove(storeProduct);
                removedStoreProduct = storeProduct;
                return removedStoreProduct;
            }
        }

        return removedStoreProduct;
    }
}

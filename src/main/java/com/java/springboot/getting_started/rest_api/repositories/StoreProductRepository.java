package com.java.springboot.getting_started.rest_api.repositories;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.java.springboot.getting_started.rest_api.mock_database.MockDatabase;
import com.java.springboot.getting_started.rest_api.models.data_objects.DataObjects.StoreProduct;
import com.java.springboot.getting_started.rest_api.models.interfaces.IBaseRepository;

@Repository
public class StoreProductRepository implements IBaseRepository<StoreProduct> {

    private final MockDatabase mockDatabase = MockDatabase.getInstance();

    @Override
    public StoreProduct[] findAll() {
        return mockDatabase.getStoreProducts();
    }

    @Override
    public StoreProduct findByUUID(UUID id) {
        for (StoreProduct sp : mockDatabase.getStoreProducts()) {
            if (sp.productId().equals(id)) {
                return sp;
            }
        }

        return null;
    }

    @Override
    public StoreProduct add(StoreProduct t) {
        if (t.productId() == null) {
            t = new StoreProduct(UUID.randomUUID(), t.description(), t.inventoryCount(), t.price(), t.productName());
        }
        mockDatabase.addStoreProduct(t);

        return t;
    }

    @Override
    public StoreProduct updateByUUID(UUID id, StoreProduct t) {
        StoreProduct[] products = mockDatabase.getStoreProducts();
        for (int i = 0; i < products.length; i++) {
            if (products[i].productId().equals(id)) {
                products[i] = t;
                return products[i];
            }
        }
        return null;
    }

    @Override
    public StoreProduct deleteByUUID(UUID id) {
        return mockDatabase.removeStoreProduct(id);
    }

    @Override
    public StoreProduct findByName(String productName) {
        for (StoreProduct sp : mockDatabase.getStoreProducts()) {
            if (sp.productName().equals(productName)) {
                return sp;
            }
        }

        return null;
    }
}

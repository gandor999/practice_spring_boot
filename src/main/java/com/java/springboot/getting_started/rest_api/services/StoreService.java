package com.java.springboot.getting_started.rest_api.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.java.springboot.getting_started.rest_api.models.data_objects.DataObjects.StoreProduct;
import com.java.springboot.getting_started.rest_api.models.interfaces.IStoreService;
import com.java.springboot.getting_started.rest_api.repositories.StoreProductRepository;

@Service
public class StoreService implements IStoreService {

    private StoreProductRepository storeProductRepository = null;

    public StoreService(StoreProductRepository storeProductRepository) {
        this.storeProductRepository = storeProductRepository;
    }

    @Override
    public String getStoreLanding() {
        return "Hello World";
    }

    @Override
    public StoreProduct[] getStoreProducts() {
        return storeProductRepository.findAll();
    }

    @Override
    public StoreProduct getStoreProduct(String productName) {
        return storeProductRepository.findByName(productName);
    }

    @Override
    public StoreProduct getStoreProduct(UUID productId) {
        return storeProductRepository.findByUUID(productId);
    }

    @Override
    public StoreProduct addProduct(StoreProduct storeProduct) {
        return storeProductRepository.add(storeProduct);
    }

    @Override
    public StoreProduct updateStoreProduct(UUID productId, StoreProduct storeProduct) {
        return storeProductRepository.updateByUUID(productId, storeProduct);
    }

    @Override
    public StoreProduct removeStoreProduct(UUID productId) {
        return storeProductRepository.deleteByUUID(productId);
    }
}

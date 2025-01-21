package com.java.springboot.getting_started.rest_api.models.interfaces;

import java.util.UUID;

import com.java.springboot.getting_started.rest_api.models.data_objects.DataObjects.StoreProduct;

public interface IStoreController {
    public String getStoreLanding();

    public StoreProduct[] getStoreProducts();

    public StoreProduct getStoreProduct(String productName, UUID productId);

    public StoreProduct addProduct(StoreProduct storeProduct);

    public StoreProduct updateStoreProduct(UUID productId, StoreProduct storeProduct);

    public StoreProduct removeStoreProduct(UUID productId);
}

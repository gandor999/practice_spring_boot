package com.java.springboot.getting_started.rest_api.models.interfaces;

import com.java.springboot.getting_started.rest_api.models.data_objects.DataObjects.StoreProduct;

public interface IStoreService {
    public String getStoreLanding();

    public StoreProduct[] getStoreProducts();

    public StoreProduct getStoreProduct(String productName);

    public StoreProduct getStoreProduct(long productId);

    public StoreProduct addProduct(StoreProduct storeProduct);
}

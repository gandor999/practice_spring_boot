package com.java.springboot.getting_started.rest_api.services;

import org.springframework.stereotype.Service;

import com.java.springboot.getting_started.rest_api.models.data_objects.DataObjects.StoreProduct;
import com.java.springboot.getting_started.rest_api.models.interfaces.IStoreService;

@Service
public class StoreService implements IStoreService {

    @Override
    public String getStoreLanding() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getStoreLanding'");
    }

    @Override
    public StoreProduct[] getStoreProducts() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getStoreProducts'");
    }

    @Override
    public StoreProduct getStoreProduct(String productName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getStoreProduct'");
    }

    @Override
    public StoreProduct getStoreProduct(long productId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getStoreProduct'");
    }

    @Override
    public StoreProduct addProduct(StoreProduct storeProduct) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addProduct'");
    }
}

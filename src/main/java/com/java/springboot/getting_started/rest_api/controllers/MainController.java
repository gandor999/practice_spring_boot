package com.java.springboot.getting_started.rest_api.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.springboot.getting_started.rest_api.models.data_objects.DataObjects.StoreProduct;
import com.java.springboot.getting_started.rest_api.models.interfaces.IStoreController;
import com.java.springboot.getting_started.rest_api.services.StoreService;

@RestController
public class MainController implements IStoreController {

    @Autowired
    StoreService storeService;

    @GetMapping("/store_service")
    @Override
    public String getStoreLanding() {
        return storeService.getStoreLanding();
    }

    @GetMapping("/store_service/products")
    @Override
    public StoreProduct[] getStoreProducts() {
        return storeService.getStoreProducts();
    }

    @GetMapping("/store_service/product")
    @Override
    public StoreProduct getStoreProduct(@RequestParam(value = "product_name") String productName) {
        return storeService.getStoreProduct(productName);
    }

    @GetMapping("/store_service/id")
    @Override
    public StoreProduct getStoreProduct(@RequestParam(value = "product_id") UUID productId) {
        return storeService.getStoreProduct(productId);
    }

    @PostMapping("/store_service/product")
    @Override
    public StoreProduct addProduct(@RequestBody StoreProduct storeProduct) {
        return storeService.addProduct(storeProduct);
    }

    @PutMapping("/store_service/id")
    @Override
    public StoreProduct updateStoreProduct(@RequestParam(value = "product_id") UUID productId,
            StoreProduct storeProduct) {
        return storeService.updateStoreProduct(productId, storeProduct);
    }

    @DeleteMapping("/store_service/id")
    @Override
    public StoreProduct removeStoreProduct(@RequestParam(value = "product_id") UUID productId) {
        return storeService.removeStoreProduct(productId);
    }
}

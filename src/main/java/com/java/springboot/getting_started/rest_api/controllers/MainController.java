package com.java.springboot.getting_started.rest_api.controllers;

import java.util.Optional;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.springboot.getting_started.rest_api.models.Test;
import com.java.springboot.getting_started.rest_api.models.data_objects.DataObjects.StoreProduct;
import com.java.springboot.getting_started.rest_api.models.interfaces.IStoreController;
import com.java.springboot.getting_started.rest_api.models.interfaces.request.TestRequest;
import com.java.springboot.getting_started.rest_api.services.StoreService;
import com.java.springboot.getting_started.rest_api.validation.Validate;

@RestController
public class MainController implements IStoreController {

    private StoreService storeService = null;

    public MainController(StoreService storeService) {
        this.storeService = storeService;
    }

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
    public StoreProduct getStoreProduct(
            @RequestParam(value = "product_name", required = false) String productName,
            @RequestParam(value = "product_id") UUID productId) {
        System.out.println("productName: " + productName);
        System.out.println("productId: " + productId);

        if (productName != null) {
            return storeService.getStoreProduct(productName);
        }

        if (productId != null) {
            return storeService.getStoreProduct(productId);
        }

        return null;
    }

    @PatchMapping("/store_service/product")
    @Override
    public StoreProduct updateStoreProduct(
        @RequestParam(value = "product_id") UUID productId,
        @RequestBody StoreProduct storeProduct) {
        return storeService.updateStoreProduct(productId, storeProduct);
    }

    @DeleteMapping("/store_service/product")
    @Override
    public StoreProduct removeStoreProduct(@RequestParam(value = "product_id") UUID productId) {
        return storeService.removeStoreProduct(productId);
    }

    @PostMapping("/store_service/product")
    @Override
    public StoreProduct addProduct(@RequestBody StoreProduct storeProduct) {
        return storeService.addProduct(storeProduct);
    }

    @GetMapping("/test")
    public Test getTest() {
        return new Test();
    }

    @PostMapping("/test")
    @Validate
    public TestRequest addTest(@RequestBody TestRequest test) {
        return test;
    }
}

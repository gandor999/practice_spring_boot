package com.java.springboot.getting_started.rest_api.controllers;

import java.util.Optional;
import java.util.UUID;

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
        @RequestParam(value = "product_id") UUID productId
    ) {
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

    @PutMapping("/store_service/product")
    @Override
    public StoreProduct updateStoreProduct(@RequestParam(value = "product_id") UUID productId,
            StoreProduct storeProduct) {
        return storeService.updateStoreProduct(productId, storeProduct);
    }

    @PostMapping("/store_service/product")
    @Override
    public StoreProduct addProduct(@RequestBody StoreProduct storeProduct) {
        return storeService.addProduct(storeProduct);
    }

    @DeleteMapping("/store_service/id")
    @Override
    public StoreProduct removeStoreProduct(@RequestParam(value = "product_id") UUID productId) {
        return storeService.removeStoreProduct(productId);
    }
}

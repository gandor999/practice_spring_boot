package com.java.springboot.getting_started.rest_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.java.springboot.getting_started.rest_api.models.data_objects.DataObjects.StoreProduct;
import com.java.springboot.getting_started.rest_api.models.interfaces.IStoreController;
import com.java.springboot.getting_started.rest_api.services.StoreService;

@RestController
public class MainController implements IStoreController {

    @Autowired
    StoreService storeService;

    @GetMapping("/sample_internal_error")
    public void sampleInternalError() throws Exception {
        throw new Exception(
                "normal custom exception, example: something happened during runtime in server | this is a pretty generalized error");
    }

    @GetMapping("/sample_http_error")
    public void sampleHttpError() throws HttpClientErrorException {
        throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR, "custom exception");
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
    public StoreProduct getStoreProduct(@RequestParam(value = "product_name") String productName) {
        return storeService.getStoreProduct(productName);
    }

    @GetMapping("/store_service/id")
    @Override
    public StoreProduct getStoreProduct(@RequestParam(value = "product_id") long productId) {
        return storeService.getStoreProduct(productId);
    }

    @PostMapping("/store_service/product")
    @Override
    public StoreProduct addProduct(@RequestBody StoreProduct storeProduct) {
        return storeService.addProduct(storeProduct);
    }
}

package com.example.deliveryapp.service;

import com.example.deliveryapp.DatabaseTest;
import com.example.deliveryapp.dto.ProductDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductServiceTest extends DatabaseTest {

    private final ProductService productService;

    @Autowired
    public ProductServiceTest(ProductService productService) {
        this.productService = productService;
    }

    @Test
    public void createProductTest() {
        ProductDto product = productService.create(new ProductDto(null, "test", null));
        Assertions.assertNotNull(product.getId());
    }

}

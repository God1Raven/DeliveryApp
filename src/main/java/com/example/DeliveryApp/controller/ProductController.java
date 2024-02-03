package com.example.DeliveryApp.controller;

import com.example.DeliveryApp.dto.ProductDto;
import com.example.DeliveryApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController extends CrudController<ProductDto>{
    @Autowired
    public ProductController(ProductService productService) {
        this.baseService = productService;
    }
}

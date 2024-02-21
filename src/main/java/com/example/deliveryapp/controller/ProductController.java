package com.example.deliveryapp.controller;

import com.example.deliveryapp.dto.FindByDateSortByRatingDto;
import com.example.deliveryapp.dto.ProductDto;
import com.example.deliveryapp.dto.request.FindProductsByDateRequest;
import com.example.deliveryapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController extends CrudController<ProductDto, ProductService> {
    @Autowired
    public ProductController(ProductService productService) {
        this.baseService = productService;
    }

    @RequestMapping(value = "findByDateSortByAvgRate", method = RequestMethod.POST)
    public List<FindByDateSortByRatingDto> findByDateSortByRating(@RequestBody FindProductsByDateRequest request) {
        return baseService.findByDateSortByRatingDto(request.getFirstDate(), request.getSecondDate());
    }
}

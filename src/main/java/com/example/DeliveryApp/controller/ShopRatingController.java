package com.example.DeliveryApp.controller;

import com.example.DeliveryApp.dto.ShopRatingDto;
import com.example.DeliveryApp.service.ShopRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shop_rating")

public class ShopRatingController extends CrudController<ShopRatingDto>{
    @Autowired
    public ShopRatingController(ShopRatingService shopRatingService) {
        this.baseService = shopRatingService;
    }
}

package com.example.deliveryapp.controller;

import com.example.deliveryapp.dto.ShopRatingDto;
import com.example.deliveryapp.service.ShopRatingService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shop_rating")
@PreAuthorize("hasRole('CLIENT')")
@SecurityRequirement(name = "bearerAuth")
public class ShopRatingController extends CrudController<ShopRatingDto, ShopRatingService> {
    @Autowired
    public ShopRatingController(ShopRatingService shopRatingService) {
        this.baseService = shopRatingService;
    }
}

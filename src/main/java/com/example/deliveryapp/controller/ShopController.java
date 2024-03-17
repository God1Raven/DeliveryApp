package com.example.deliveryapp.controller;

import com.example.deliveryapp.dto.ShopDto;
import com.example.deliveryapp.service.ShopService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shop")
@SecurityRequirement(name = "bearerAuth")
@PreAuthorize("hasRole('CLIENT')")
public class ShopController extends CrudController<ShopDto, ShopService>{
    @Autowired
    public ShopController(ShopService shopService) {
        this.baseService = shopService;
    }
}

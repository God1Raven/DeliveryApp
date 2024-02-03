package com.example.DeliveryApp.controller;

import com.example.DeliveryApp.dto.ShopDto;
import com.example.DeliveryApp.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shop")
public class ShopController extends CrudController<ShopDto>{
    @Autowired
    public ShopController(ShopService shopService) {
        this.baseService = shopService;
    }
}

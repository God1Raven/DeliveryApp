package com.example.DeliveryApp.controller;

import com.example.DeliveryApp.dto.CourierDto;
import com.example.DeliveryApp.service.CourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courier")

public class CourierController extends CrudController<CourierDto>{
    @Autowired
    public CourierController(CourierService courierService) {
        this.baseService = courierService;
    }
}

package com.example.deliveryapp.controller;

import com.example.deliveryapp.dto.CourierDto;
import com.example.deliveryapp.service.CourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courier")

public class CourierController extends CrudController<CourierDto, CourierService>{
    @Autowired
    public CourierController(CourierService courierService) {
        this.baseService = courierService;
    }
}

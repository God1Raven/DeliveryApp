package com.example.DeliveryApp.controller;

import com.example.DeliveryApp.dto.OrderProductDto;
import com.example.DeliveryApp.service.OrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order_product")
public class OrderProductController extends CrudController<OrderProductDto>{
    @Autowired
    public OrderProductController(OrderProductService orderProductService) {
        this.baseService = orderProductService;
    }
}

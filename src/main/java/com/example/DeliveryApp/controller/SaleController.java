package com.example.DeliveryApp.controller;

import com.example.DeliveryApp.dto.SaleDto;
import com.example.DeliveryApp.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sale")
public class SaleController extends CrudController<SaleDto>{
    @Autowired
    public SaleController(SaleService saleService) {
        this.baseService = saleService;
    }
}

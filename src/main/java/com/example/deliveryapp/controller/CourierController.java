package com.example.deliveryapp.controller;

import com.example.deliveryapp.dto.CourierDto;
import com.example.deliveryapp.dto.FindCourierByProductDto;
import com.example.deliveryapp.dto.request.FindCourierByProductRequest;
import com.example.deliveryapp.service.CourierService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courier")
@SecurityRequirement(name = "bearerAuth")
@PreAuthorize("hasRole('CLIENT')")
public class CourierController extends CrudController<CourierDto, CourierService> {
    @Autowired
    public CourierController(CourierService courierService) {
        this.baseService = courierService;
    }

    @RequestMapping(value = "findCourierByProduct", method = RequestMethod.POST)
    public List<FindCourierByProductDto> findCourierByProductDto(@RequestBody FindCourierByProductRequest request) {
        return baseService.findCourierByProductDto(request.getProductName(), request.getShopRating());
    }
}

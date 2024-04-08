package com.example.deliveryapp.controller;

import com.example.deliveryapp.dto.FindSaleByAddressByAvgRatingDto;
import com.example.deliveryapp.dto.SaleDto;
import com.example.deliveryapp.dto.StatusSale;
import com.example.deliveryapp.dto.request.FindSaleByAddressAndAvgRatingRequest;
import com.example.deliveryapp.service.SaleService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sale")
@SecurityRequirement(name = "bearerAuth")
@PreAuthorize("hasRole('CLIENT')")
public class SaleController extends CrudController<SaleDto, SaleService> {
    @Autowired
    public SaleController(SaleService saleService) {
        this.baseService = saleService;
    }

    @RequestMapping(value = "all/{status}", method = RequestMethod.GET)
    public List<SaleDto> getAllByStatusSale(@PathVariable("status") StatusSale status) {
        return baseService.getAllByStatus(status);
    }

    @RequestMapping(value = "findSaleByAddress", method = RequestMethod.POST)
    public List<FindSaleByAddressByAvgRatingDto> findSaleByAddressByAvgRatingDto(
            @RequestBody FindSaleByAddressAndAvgRatingRequest request) {
        return baseService.findSaleByAddressByAvgRatingDto(request.getAddress(), request.getShopRating());
    }
}

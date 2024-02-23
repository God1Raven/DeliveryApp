package com.example.deliveryapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FindSaleByAddressByAvgRatingDto {

    Long id;
    String address;
    Long shopId;
    String shopName;
}

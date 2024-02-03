package com.example.DeliveryApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ShopRatingDto {
    private Long id;
    private Long shopId;
    private String rating;
}

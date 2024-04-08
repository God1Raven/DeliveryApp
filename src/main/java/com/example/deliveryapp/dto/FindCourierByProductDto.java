package com.example.deliveryapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FindCourierByProductDto {

    Long id;
    String name;
    String productName;
    String shopName;
    Short shopRating;
}

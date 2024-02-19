package com.example.deliveryapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FindByDateSortByRatingDto {

    Long id;
    String productName;
    String shopName;
    Double shopRating;
}

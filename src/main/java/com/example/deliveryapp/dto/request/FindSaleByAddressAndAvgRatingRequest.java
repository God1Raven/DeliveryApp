package com.example.deliveryapp.dto.request;


import lombok.Data;

@Data
public class FindSaleByAddressAndAvgRatingRequest {
    String address;
    Short shopRating;
}

package com.example.deliveryapp.dto.request;

import lombok.Data;

@Data
public class FindCourierByProductRequest {
    String productName;
    Short shopRating;
}

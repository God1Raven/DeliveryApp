package com.example.deliveryapp.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class FindCourierByProductRequest {
    String productName;
    Short shopRating;
}

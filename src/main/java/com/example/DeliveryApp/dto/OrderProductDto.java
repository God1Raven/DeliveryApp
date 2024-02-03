package com.example.DeliveryApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class OrderProductDto {
    private Long id;
    private Long orderId;
    private Long productId;
}

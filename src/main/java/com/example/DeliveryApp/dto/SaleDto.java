package com.example.DeliveryApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
public class SaleDto {
    private Long id;
    private LocalDateTime deliveryDate;
    private String address;
    private Long userId;
    private Long courierId;
    private Long shopId;
    private StatusSale status;
}

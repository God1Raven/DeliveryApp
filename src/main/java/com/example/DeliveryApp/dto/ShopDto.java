package com.example.DeliveryApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ShopDto {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
}

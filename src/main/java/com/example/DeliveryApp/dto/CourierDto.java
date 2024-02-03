package com.example.DeliveryApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CourierDto {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String phoneNumber;
}

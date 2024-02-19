package com.example.deliveryapp.dto.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FindProductsByDateRequest {
    private LocalDateTime after;
    private LocalDateTime before;
}

package com.example.deliveryapp.dto;

import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SaleDto {
    private Long id;
    private LocalDateTime deliveryDate;
    private String address;
    private Long clientId;
    private Long courierId;
    private Long shopId;
    private List<Long> productIds;
    private StatusSale status;
}

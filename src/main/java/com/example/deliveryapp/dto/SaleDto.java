package com.example.deliveryapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class SaleDto {
    private Long id;
    private LocalDate deliveryDate;
    private String address;
    private Long clientId;
    private Long courierId;
    private Long shopId;
    private List<Long> productIds;
    private StatusSale status;
}

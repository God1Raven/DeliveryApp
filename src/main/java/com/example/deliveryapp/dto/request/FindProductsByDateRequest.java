package com.example.deliveryapp.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.testcontainers.shaded.org.checkerframework.checker.units.qual.N;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindProductsByDateRequest {
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate firstDate;
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate secondDate;
}

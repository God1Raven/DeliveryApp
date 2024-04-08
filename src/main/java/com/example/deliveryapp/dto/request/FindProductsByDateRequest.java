package com.example.deliveryapp.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindProductsByDateRequest {
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate firstDate;
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate secondDate;
}

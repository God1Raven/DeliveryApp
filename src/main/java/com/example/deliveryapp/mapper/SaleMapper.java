package com.example.deliveryapp.mapper;

import com.example.deliveryapp.dto.SaleDto;
import com.example.deliveryapp.entity.Sale;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SaleMapper {
    Sale mapDtoToEntity(SaleDto saleDto);
    SaleDto mapEntityToDto (Sale sale);
}

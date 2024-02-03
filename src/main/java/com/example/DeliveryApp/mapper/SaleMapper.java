package com.example.DeliveryApp.mapper;

import com.example.DeliveryApp.dto.SaleDto;
import com.example.DeliveryApp.entity.Sale;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SaleMapper {
    Sale mapDtoToEntity(SaleDto saleDto);
    SaleDto mapEntityToDto (Sale sale);
}

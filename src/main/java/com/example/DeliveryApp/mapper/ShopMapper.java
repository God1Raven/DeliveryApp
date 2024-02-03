package com.example.DeliveryApp.mapper;

import com.example.DeliveryApp.dto.ShopDto;
import com.example.DeliveryApp.entity.Shop;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface ShopMapper {
    Shop mapDtoToEntity(ShopDto shopDto);
    ShopDto mapEntityToDto (Shop shop);
}

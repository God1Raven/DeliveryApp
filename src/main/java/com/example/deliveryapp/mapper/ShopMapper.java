package com.example.deliveryapp.mapper;

import com.example.deliveryapp.dto.ShopDto;
import com.example.deliveryapp.entity.Shop;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface ShopMapper {
    Shop mapDtoToEntity(ShopDto shopDto);

    ShopDto mapEntityToDto(Shop shop);
}

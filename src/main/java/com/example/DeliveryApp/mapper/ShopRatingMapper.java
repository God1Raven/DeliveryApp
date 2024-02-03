package com.example.DeliveryApp.mapper;

import com.example.DeliveryApp.dto.ShopRatingDto;
import com.example.DeliveryApp.entity.ShopRating;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ShopRatingMapper {
    ShopRating mapDtoToEntity(ShopRatingDto shopRatingDto);
    ShopRatingDto mapEntityToDto (ShopRating shopRating);
}

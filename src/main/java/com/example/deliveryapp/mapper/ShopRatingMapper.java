package com.example.deliveryapp.mapper;

import com.example.deliveryapp.dto.ShopRatingDto;
import com.example.deliveryapp.entity.ShopRating;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ShopRatingMapper {
    ShopRating mapDtoToEntity(ShopRatingDto shopRatingDto);
    ShopRatingDto mapEntityToDto (ShopRating shopRating);
}

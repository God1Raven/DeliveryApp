package com.example.deliveryapp.mapper;

import com.example.deliveryapp.dto.CourierDto;
import com.example.deliveryapp.dto.FindCourierByProductDto;
import com.example.deliveryapp.entity.Courier;
import com.example.deliveryapp.entity.FindCourierByProduct;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourierMapper {
    Courier mapDtoToEntity(CourierDto courierDto);

    CourierDto mapEntityToDto(Courier courier);
    FindCourierByProductDto mapCustomEntityToCustomDto(FindCourierByProduct findCourierByProduct);
}

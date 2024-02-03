package com.example.DeliveryApp.mapper;

import com.example.DeliveryApp.dto.CourierDto;
import com.example.DeliveryApp.entity.Courier;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface CourierMapper {
    Courier mapDtoToEntity(CourierDto courierDto);
    CourierDto mapEntityToDto (Courier courier);
}

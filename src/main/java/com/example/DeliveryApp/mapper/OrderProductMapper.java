package com.example.DeliveryApp.mapper;

import com.example.DeliveryApp.dto.OrderProductDto;
import com.example.DeliveryApp.entity.OrderProduct;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderProductMapper {
    OrderProduct mapDtoToEntity(OrderProductDto orderProductDto);
    OrderProductDto mapEntityToDto (OrderProduct orderProduct);
}

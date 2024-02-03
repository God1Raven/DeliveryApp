package com.example.DeliveryApp.mapper;

import com.example.DeliveryApp.dto.ProductDto;
import com.example.DeliveryApp.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface ProductMapper {
    Product mapDtoToEntity(ProductDto productDto);
    ProductDto mapEntityToDto (Product product);
}

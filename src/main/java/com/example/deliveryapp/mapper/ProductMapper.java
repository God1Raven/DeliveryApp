package com.example.deliveryapp.mapper;

import com.example.deliveryapp.dto.ProductDto;
import com.example.deliveryapp.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface ProductMapper {
    Product mapDtoToEntity(ProductDto productDto);
    ProductDto mapEntityToDto (Product product);
}

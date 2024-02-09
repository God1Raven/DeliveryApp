package com.example.deliveryapp.mapper;

import com.example.deliveryapp.dto.ProductDto;
import com.example.deliveryapp.entity.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")

public abstract class ProductMapper {

    @Autowired
    private ObjectMapper mapper;

    public abstract Product mapDtoToEntity(ProductDto productDto);

    public abstract ProductDto mapEntityToDto(Product product);

    protected String mapJsonToString(JsonNode json) {
        try {
            return mapper.writeValueAsString(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    protected JsonNode mapJsonToString(String json) {
        try {
            return mapper.readValue(json, JsonNode.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}

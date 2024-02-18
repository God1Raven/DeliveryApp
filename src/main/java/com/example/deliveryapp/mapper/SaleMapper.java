package com.example.deliveryapp.mapper;

import com.example.deliveryapp.dto.SaleDto;
import com.example.deliveryapp.entity.Client;
import com.example.deliveryapp.entity.Courier;
import com.example.deliveryapp.entity.Product;
import com.example.deliveryapp.entity.Sale;
import com.example.deliveryapp.entity.Shop;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Mapper(componentModel = "spring")
public interface SaleMapper {

    Sale mapDtoToEntity(SaleDto saleDto);

    @Mappings(value = {
            @Mapping(source = "courier", target = "courierId"),
            @Mapping(source = "client", target = "clientId"),
            @Mapping(source = "shop", target = "shopId"),
            @Mapping(source = "products", target = "productIds")
    })
    SaleDto mapEntityToDto(Sale sale);

    default Long mapToId(Courier courier) {
        return courier != null ? courier.getId() : null;
    }

    default Long mapToId(Client client) {
        return client != null ? client.getId() : null;
    }

    default Long mapToId(Shop shop) {
        return shop != null ? shop.getId() : null;
    }

    default Long mapToId(Product product) {
        return product != null ? product.getId() : null;
    }
}

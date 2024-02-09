package com.example.deliveryapp.mapper;

import com.example.deliveryapp.dto.SaleDto;
import com.example.deliveryapp.entity.Client;
import com.example.deliveryapp.entity.Courier;
import com.example.deliveryapp.entity.Sale;
import com.example.deliveryapp.entity.Shop;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface SaleMapper {

    Sale mapDtoToEntity(SaleDto saleDto);


    @Mappings(value = {@Mapping(source = "courier", target = "courierId"), @Mapping(source = "client", target = "clientId"), @Mapping(source = "shop", target = "shopId")})
    SaleDto mapEntityToDto(Sale sale);

    default Long mapToId(Courier courier) {
        return courier.getId();
    }

    default Long mapToId(Client client) {
        return client.getId();
    }

    default Long mapToId(Shop shop) {
        return shop.getId();
    }
}

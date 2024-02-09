package com.example.deliveryapp.mapper;

import com.example.deliveryapp.dto.ClientDto;
import com.example.deliveryapp.entity.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    Client mapDtoToEntity(ClientDto dto);

    ClientDto mapEntityToDto(Client client);

}

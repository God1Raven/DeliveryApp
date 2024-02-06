package com.example.DeliveryApp.mapper;

import com.example.DeliveryApp.dto.UserDto;
import com.example.DeliveryApp.entity.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    Client mapDtoToEntity(UserDto dto);

    UserDto mapEntityToDto(Client client);

}

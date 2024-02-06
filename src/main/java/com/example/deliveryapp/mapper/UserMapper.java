package com.example.deliveryapp.mapper;

import com.example.deliveryapp.dto.UserDto;
import com.example.deliveryapp.entity.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    Client mapDtoToEntity(UserDto dto);

    UserDto mapEntityToDto(Client client);

}

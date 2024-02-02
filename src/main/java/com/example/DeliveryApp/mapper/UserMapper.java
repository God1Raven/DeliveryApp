package com.example.DeliveryApp.mapper;

import com.example.DeliveryApp.dto.UserDto;
import com.example.DeliveryApp.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User mapDtoToEntity(UserDto dto);

    UserDto mapEntityToDto(User user);

}

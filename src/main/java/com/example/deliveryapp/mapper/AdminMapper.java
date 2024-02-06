package com.example.deliveryapp.mapper;

import com.example.deliveryapp.dto.AdminDto;
import com.example.deliveryapp.entity.Admin;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdminMapper {
    Admin mapDtoToEntity(AdminDto adminDto);

    AdminDto mapEntityToDto(Admin admin);
}

package com.example.DeliveryApp.mapper;

import com.example.DeliveryApp.dto.AdminDto;
import com.example.DeliveryApp.entity.Admin;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdminMapper {
    Admin mapDtoToEntity(AdminDto adminDto);

    AdminDto mapEntityToDto(Admin admin);
}

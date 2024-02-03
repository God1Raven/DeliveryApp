package com.example.DeliveryApp.service;

import com.example.DeliveryApp.dto.CourierDto;
import com.example.DeliveryApp.mapper.CourierMapper;
import com.example.DeliveryApp.repository.CourierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class CourierService implements BaseService<CourierDto> {
    private CourierRepository courierRepository;
    private CourierMapper courierMapper;

    @Autowired
    public CourierService(CourierRepository courierRepository, CourierMapper courierMapper) {
        this.courierRepository = courierRepository;
        this.courierMapper = courierMapper;
    }

    public CourierDto create(CourierDto courierDto) {
        return courierMapper.mapEntityToDto(courierRepository.save(courierMapper.mapDtoToEntity(courierDto)));
    }

    public CourierDto update(CourierDto courierDto) {
        return courierMapper.mapEntityToDto(courierRepository.save(courierMapper.mapDtoToEntity(courierDto)));
    }

    public CourierDto get(Long id) {
        return courierRepository.findById(id).map(x -> courierMapper.mapEntityToDto(x)).orElse(null);
    }

    public void delete(Long id) {
        courierRepository.deleteById(id);
    }
}
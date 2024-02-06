package com.example.deliveryapp.service;

import com.example.deliveryapp.dto.CourierDto;
import com.example.deliveryapp.mapper.CourierMapper;
import com.example.deliveryapp.repository.CourierRepository;
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

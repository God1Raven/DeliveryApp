package com.example.DeliveryApp.service;

import com.example.DeliveryApp.dto.OrderProductDto;
import com.example.DeliveryApp.mapper.OrderProductMapper;
import com.example.DeliveryApp.repository.OrderProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class OrderProductService implements BaseService<OrderProductDto>{
    private OrderProductRepository orderProductRepository;
    private OrderProductMapper orderProductMapper;

    @Autowired
    public OrderProductService(OrderProductRepository orderProductRepository, OrderProductMapper orderProductMapper) {
        this.orderProductRepository = orderProductRepository;
        this.orderProductMapper = orderProductMapper;
    }

    public OrderProductDto create(OrderProductDto orderProductDto) {
        return orderProductMapper.mapEntityToDto(orderProductRepository.save(orderProductMapper.mapDtoToEntity(orderProductDto)));
    }

    public OrderProductDto update(OrderProductDto orderProductDto) {
        return orderProductMapper.mapEntityToDto(orderProductRepository.save(orderProductMapper.mapDtoToEntity(orderProductDto)));
    }

    public OrderProductDto get(Long id) {
        return orderProductRepository.findById(id).map(x -> orderProductMapper.mapEntityToDto(x)).orElse(null);
    }

    public void delete(Long id) {
        orderProductRepository.deleteById(id);
    }
}

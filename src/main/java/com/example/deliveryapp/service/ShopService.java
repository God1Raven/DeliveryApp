package com.example.deliveryapp.service;

import com.example.deliveryapp.dto.ShopDto;
import com.example.deliveryapp.mapper.ShopMapper;
import com.example.deliveryapp.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ShopService implements BaseService<ShopDto>{
    private final ShopRepository shopRepository;
    private final ShopMapper shopMapper;

    @Autowired
    public ShopService(ShopRepository shopRepository, ShopMapper shopMapper) {
        this.shopRepository = shopRepository;
        this.shopMapper = shopMapper;
    }

    public ShopDto create(ShopDto shopDto) {
        return shopMapper.mapEntityToDto(shopRepository.save(shopMapper.mapDtoToEntity(shopDto)));
    }

    public ShopDto update(ShopDto shopDto) {
        return shopMapper.mapEntityToDto(shopRepository.save(shopMapper.mapDtoToEntity(shopDto)));
    }

    public ShopDto get(Long id) {
        return shopRepository.findById(id).map(x -> shopMapper.mapEntityToDto(x)).orElse(null);
    }

    public void delete(Long id) {
        shopRepository.deleteById(id);
    }
}

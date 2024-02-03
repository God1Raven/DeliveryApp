package com.example.DeliveryApp.service;

import com.example.DeliveryApp.dto.ShopRatingDto;
import com.example.DeliveryApp.mapper.ShopRatingMapper;
import com.example.DeliveryApp.repository.ShopRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ShopRatingService implements BaseService<ShopRatingDto>{
    private ShopRatingRepository shopRatingRepository;
    private ShopRatingMapper shopRatingMapper;

    @Autowired
    public ShopRatingService(ShopRatingRepository shopRatingRepository, ShopRatingMapper shopRatingMapper) {
        this.shopRatingRepository = shopRatingRepository;
        this.shopRatingMapper = shopRatingMapper;
    }

    public ShopRatingDto create(ShopRatingDto shopRatingDto) {
        return shopRatingMapper.mapEntityToDto(shopRatingRepository.save(shopRatingMapper.mapDtoToEntity(shopRatingDto)));
    }

    public ShopRatingDto update(ShopRatingDto shopRatingDto) {
        return shopRatingMapper.mapEntityToDto(shopRatingRepository.save(shopRatingMapper.mapDtoToEntity(shopRatingDto)));
    }

    public ShopRatingDto get(Long id) {
        return shopRatingRepository.findById(id).map(x -> shopRatingMapper.mapEntityToDto(x)).orElse(null);
    }

    public void delete(Long id) {
        shopRatingRepository.deleteById(id);
    }
}

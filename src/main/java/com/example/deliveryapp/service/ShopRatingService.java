package com.example.deliveryapp.service;

import com.example.deliveryapp.dto.AdminDto;
import com.example.deliveryapp.dto.ShopRatingDto;
import com.example.deliveryapp.mapper.ShopRatingMapper;
import com.example.deliveryapp.repository.ShopRatingRepository;
import com.example.deliveryapp.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class ShopRatingService implements BaseService<ShopRatingDto>{
    private final ShopRatingRepository shopRatingRepository;
    private final ShopRatingMapper shopRatingMapper;

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
    @Override
    public List<ShopRatingDto> getAll() {
        return shopRatingRepository.findAll().stream().map(shopRatingMapper::mapEntityToDto).collect(Collectors.toList());
    }
}

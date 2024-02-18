package com.example.deliveryapp.service;

import com.example.deliveryapp.dto.AdminDto;
import com.example.deliveryapp.dto.ProductDto;
import com.example.deliveryapp.mapper.ProductMapper;
import com.example.deliveryapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class ProductService implements BaseService<ProductDto>{
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public ProductDto create(ProductDto productDto) {
        return productMapper.mapEntityToDto(productRepository.save(productMapper.mapDtoToEntity(productDto)));
    }

    public ProductDto update(ProductDto productDto) {
        return productMapper.mapEntityToDto(productRepository.save(productMapper.mapDtoToEntity(productDto)));
    }

    public ProductDto get(Long id) {
        return productRepository.findById(id).map(x -> productMapper.mapEntityToDto(x)).orElse(null);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
    @Override
    public List<ProductDto> getAll() {
        return productRepository.findAll().stream().map(productMapper::mapEntityToDto).collect(Collectors.toList());
    }
}

package com.example.DeliveryApp.service;

import com.example.DeliveryApp.dto.SaleDto;
import com.example.DeliveryApp.mapper.SaleMapper;
import com.example.DeliveryApp.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleService implements BaseService<SaleDto>{
    private SaleRepository saleRepository;
    private SaleMapper saleMapper;
    @Autowired
    public SaleService(SaleRepository saleRepository, SaleMapper saleMapper) {
        this.saleRepository = saleRepository;
        this.saleMapper = saleMapper;
    }
    public SaleDto create(SaleDto saleDto) {
        return saleMapper.mapEntityToDto(saleRepository.save(saleMapper.mapDtoToEntity(saleDto)));
    }
    public SaleDto update(SaleDto saleDto) {
        return saleMapper.mapEntityToDto(saleRepository.save(saleMapper.mapDtoToEntity(saleDto)));
    }
    public SaleDto get(Long id) {
        return saleRepository.findById(id).map(x -> saleMapper.mapEntityToDto(x)).orElse(null);
    }
    public void delete(Long id) {
        saleRepository.deleteById(id);
    }
}

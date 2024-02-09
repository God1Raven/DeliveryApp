package com.example.deliveryapp.service;

import com.example.deliveryapp.dto.SaleDto;
import com.example.deliveryapp.entity.*;
import com.example.deliveryapp.mapper.SaleMapper;
import com.example.deliveryapp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService implements BaseService<SaleDto> {
    private final SaleRepository saleRepository;
    private final CourierRepository courierRepository;
    private final ClientRepository clientRepository;
    private final ShopRepository shopRepository;
    private final ProductRepository productRepository;
    private final SaleMapper saleMapper;

    @Autowired
    public SaleService(SaleRepository saleRepository, CourierRepository courierRepository,
                       ShopRepository shopRepository,
                       ProductRepository productRepository,
                       ClientRepository clientRepository,
                       SaleMapper saleMapper) {
        this.saleRepository = saleRepository;
        this.courierRepository = courierRepository;
        this.shopRepository = shopRepository;
        this.productRepository = productRepository;
        this.clientRepository = clientRepository;
        this.saleMapper = saleMapper;
    }
    public SaleDto create(SaleDto saleDto) {
        Sale sale = saleMapper.mapDtoToEntity(saleDto);
        Courier courier = courierRepository.findById(saleDto.getCourierId()).orElse(null);
        sale.setCourier(courier);
        Client client = clientRepository.findById(saleDto.getClientId()).orElse(null);
        sale.setClient(client);
        Shop shop  = shopRepository.findById(saleDto.getShopId()).orElse(null);
        sale.setShop(shop);
        List<Product> products = productRepository.findAllById(saleDto.getProductIds());
        sale.setProducts(products);
        return saleMapper.mapEntityToDto(saleRepository.save(sale));
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

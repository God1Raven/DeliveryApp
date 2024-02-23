package com.example.deliveryapp.service;

import com.example.deliveryapp.dto.FindCourierByProductDto;
import com.example.deliveryapp.dto.FindSaleByAddressByAvgRatingDto;
import com.example.deliveryapp.dto.ProductDto;
import com.example.deliveryapp.dto.SaleDto;
import com.example.deliveryapp.dto.StatusSale;
import com.example.deliveryapp.entity.Client;
import com.example.deliveryapp.entity.Courier;
import com.example.deliveryapp.entity.Product;
import com.example.deliveryapp.entity.Sale;
import com.example.deliveryapp.entity.Shop;
import com.example.deliveryapp.entity.ShopRating;
import com.example.deliveryapp.mapper.ProductMapper;
import com.example.deliveryapp.mapper.SaleMapper;
import com.example.deliveryapp.repository.ClientRepository;
import com.example.deliveryapp.repository.CourierRepository;
import com.example.deliveryapp.repository.ProductRepository;
import com.example.deliveryapp.repository.SaleRepository;
import com.example.deliveryapp.repository.ShopRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaleService implements BaseService<SaleDto> {
    private final SaleRepository saleRepository;
    private final CourierRepository courierRepository;
    private final ClientRepository clientRepository;
    private final ShopRepository shopRepository;
    private final ProductRepository productRepository;
    private final SaleMapper saleMapper;

    private final ProductMapper productMapper;

    @Autowired
    public SaleService(SaleRepository saleRepository, CourierRepository courierRepository,
                       ShopRepository shopRepository,
                       ProductRepository productRepository,
                       ClientRepository clientRepository,
                       SaleMapper saleMapper,
                       ProductMapper productMapper) {
        this.saleRepository = saleRepository;
        this.courierRepository = courierRepository;
        this.shopRepository = shopRepository;
        this.productRepository = productRepository;
        this.clientRepository = clientRepository;
        this.saleMapper = saleMapper;
        this.productMapper = productMapper;
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
    @Override
    public List<SaleDto> getAll() {
        return saleRepository.findAll().stream().map(saleMapper::mapEntityToDto).collect(Collectors.toList());
    }
    public List<SaleDto> getAllByStatus(StatusSale status){
        return saleRepository.findAllByStatus(status).stream().map(saleMapper::mapEntityToDto).collect(Collectors.toList());
    }
    public List<FindSaleByAddressByAvgRatingDto> findSaleByAddressByAvgRatingDto(String address, Short shopRating){
        return saleRepository.findSaleByAddressByAvgRating(address, shopRating.doubleValue()).stream().map(saleMapper::mapCustomEntityToCustomDto).collect(Collectors.toList());
    }
}

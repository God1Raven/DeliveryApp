package com.example.deliveryapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

import com.example.deliveryapp.DatabaseTest;
import com.example.deliveryapp.dto.ProductDto;
import com.example.deliveryapp.entity.Product;
import com.example.deliveryapp.mapper.ProductMapper;
import com.example.deliveryapp.repository.ProductRepository;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;

@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class ProductServiceTest extends DatabaseTest {

    @Autowired
    private ProductService productService;
    @MockBean
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;
    private Product productEntity = new Product(1L, List.of(), "{\"width\": 500}");
    private ProductDto productDto;
    @Autowired
    public ProductServiceTest(ProductMapper productMapper) {
        productDto = productMapper.mapEntityToDto(productEntity);
    }

    @Test
    void createProductTest() {
        Mockito.doReturn(productEntity).when(productRepository).save(any(Product.class));
        Assertions.assertEquals(productDto, productService.create(productDto));
    }

    @Test
    void deleteProductTest() {
        long entityId = 1L;
        productService.delete(entityId);
        Mockito.verify(productRepository).deleteById(entityId);
    }
    @Test
    void getAllProductTest() {
        Mockito.doReturn(List.of(productEntity)).when(productRepository).findAll();
        List<ProductDto> actual = productService.getAll();
        Mockito.verify(productRepository).findAll();
        assertEquals(1, actual.size());
        assertEquals(productDto, actual.get(0));
    }
}

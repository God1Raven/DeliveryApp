package com.example.deliveryapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

import com.example.deliveryapp.BaseTest;
import com.example.deliveryapp.dto.ShopDto;
import com.example.deliveryapp.entity.Shop;
import com.example.deliveryapp.mapper.ShopMapper;
import com.example.deliveryapp.repository.ShopRepository;
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
public class ShopServiceTest extends BaseTest {
    @Autowired
    private ShopService shopService;
    @MockBean
    private ShopRepository shopRepository;
    @Autowired
    private ShopMapper shopMapper;
    private Shop shopEntity = new Shop(1L);
    private ShopDto shopDto;
    @Autowired
    public ShopServiceTest(ShopMapper shopMapper) {
        shopDto = shopMapper.mapEntityToDto(shopEntity);
    }

    @Test
    void createShopTest() {
        Mockito.doReturn(shopEntity).when(shopRepository).save(any(Shop.class));
        Assertions.assertEquals(shopDto, shopService.create(shopDto));
    }

    @Test
    void deleteShopTest() {
        long entityId = 1L;
        shopService.delete(entityId);
        Mockito.verify(shopRepository).deleteById(entityId);
    }
    @Test
    void getAllShopTest() {
        Mockito.doReturn(List.of(shopEntity)).when(shopRepository).findAll();
        List<ShopDto> actual = shopService.getAll();
        Mockito.verify(shopRepository).findAll();
        assertEquals(1, actual.size());
        assertEquals(shopDto, actual.get(0));
    }
}

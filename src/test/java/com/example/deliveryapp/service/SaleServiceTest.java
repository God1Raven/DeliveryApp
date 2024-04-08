package com.example.deliveryapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

import com.example.deliveryapp.BaseTest;
import com.example.deliveryapp.dto.SaleDto;
import com.example.deliveryapp.dto.StatusSale;
import com.example.deliveryapp.entity.*;
import com.example.deliveryapp.mapper.SaleMapper;
import com.example.deliveryapp.repository.SaleRepository;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;

@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class SaleServiceTest extends BaseTest {
    @Autowired
    private SaleService saleService;
    @MockBean
    private SaleRepository saleRepository;
    @Autowired
    private SaleMapper saleMapper;
    private Courier courier = new Courier(1L);
    private Client client = new Client(1L);
    private Shop shop = new Shop(1L);
    private StatusSale status = StatusSale.valueOf("DELIVERED");
    private Sale saleEntity = new Sale(1L, List.of(), status, client, shop, courier);

    private SaleDto saleDto;

    @Autowired
    public SaleServiceTest(SaleMapper saleMapper) {
        saleDto = saleMapper.mapEntityToDto(saleEntity);
    }

    @Test
    void createSaleTest() {
        Mockito.doReturn(saleEntity).when(saleRepository).save(any(Sale.class));
        assertEquals(saleDto, saleService.create(saleDto));
    }

    @Test
    void deleteSaleTest() {
        long entityId = 1L;
        saleService.delete(entityId);
        Mockito.verify(saleRepository).deleteById(entityId);
    }

    @Test
    void getAllSaleTest() {
        Mockito.doReturn(List.of(saleEntity)).when(saleRepository).findAll();
        List<SaleDto> actual = saleService.getAll();
        Mockito.verify(saleRepository).findAll();
        assertEquals(1, actual.size());
        assertEquals(saleDto, actual.get(0));
    }

    @Test
    void getAllByStatusTest() {
        Mockito.doReturn(List.of(saleEntity)).when(saleRepository).findAllByStatus(eq(status));
        List<SaleDto> actual = saleService.getAllByStatus(status);
        Mockito.verify(saleRepository).findAllByStatus(status);
        assertEquals(1, actual.size());
        assertEquals(saleDto, actual.get(0));
    }
}

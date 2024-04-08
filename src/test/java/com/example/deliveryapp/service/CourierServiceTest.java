package com.example.deliveryapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

import com.example.deliveryapp.BaseTest;
import com.example.deliveryapp.dto.CourierDto;
import com.example.deliveryapp.entity.Courier;
import com.example.deliveryapp.mapper.CourierMapper;
import com.example.deliveryapp.repository.CourierRepository;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class CourierServiceTest extends BaseTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    private CourierService courierService;
    @MockBean
    private CourierRepository courierRepository;
    @Autowired
    private CourierMapper courierMapper;
    private Courier courierEntity = new Courier(1L);
    private CourierDto courierDto;
    @Autowired
    public CourierServiceTest(CourierMapper courierMapper) {
        courierDto = courierMapper.mapEntityToDto(courierEntity);
    }

    @Test
    void createCourierTest() {
        Mockito.doReturn(courierEntity).when(courierRepository).save(any(Courier.class));
        Assertions.assertEquals(courierDto, courierService.create(courierDto));
    }

    @Test
    void deleteCourierTest() {
        long entityId = 1L;
        courierService.delete(entityId);
        Mockito.verify(courierRepository).deleteById(entityId);
    }
    @Test
    void getAllCourierTest() {
        Mockito.doReturn(List.of(courierEntity)).when(courierRepository).findAll();
        List<CourierDto> actual = courierService.getAll();
        Mockito.verify(courierRepository).findAll();
        assertEquals(1, actual.size());
        assertEquals(courierDto, actual.get(0));
    }
}

package com.example.deliveryapp.service;

import com.example.deliveryapp.BaseTest;
import com.example.deliveryapp.dto.AdminDto;
import com.example.deliveryapp.dto.ShopDto;
import com.example.deliveryapp.entity.Admin;
import com.example.deliveryapp.mapper.AdminMapper;
import com.example.deliveryapp.repository.AdminRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;

@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
class AdminServiceTest extends BaseTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private AdminService adminService;
    @MockBean
    private AdminRepository adminRepository;
    private Admin adminEntity = new Admin(1L, "Alex", "Dolmatov", "alex@gmail.com");
    private AdminDto adminDto;

    @Autowired
    public AdminServiceTest(AdminMapper adminMapper) {
        adminDto = adminMapper.mapEntityToDto(adminEntity);
    }
    @Test
    void createAdminTest() {
        Mockito.doReturn(adminEntity).when(adminRepository).save(any(Admin.class));
        Assertions.assertEquals(adminDto, adminService.create(adminDto));
    }

    @Test
    void deleteAdminTest() {
        long entityId = 1L;
        adminService.delete(entityId);
        Mockito.verify(adminRepository).deleteById(entityId);
    }
    @Test
    void getAllAdminTest(){
        Mockito.doReturn(List.of(adminEntity)).when(adminRepository).findAll();
        List<AdminDto> actual = adminService.getAll();
        Mockito.verify(adminRepository).findAll();
        assertEquals(1, actual.size());
        assertEquals(adminDto, actual.get(0));
    }
}

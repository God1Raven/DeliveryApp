package com.example.deliveryapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

import com.example.deliveryapp.BaseTest;
import com.example.deliveryapp.dto.ClientDto;
import com.example.deliveryapp.entity.Client;
import com.example.deliveryapp.mapper.ClientMapper;
import com.example.deliveryapp.repository.ClientRepository;
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
class ClientServiceTest extends BaseTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ClientService clientService;
    @MockBean
    private ClientRepository clientRepository;
    @Autowired
    private ClientMapper clientMapper;
    private Client clientEntity = new Client(1L);
    private ClientDto clientDto;
    @Autowired
    public ClientServiceTest(ClientMapper clientMapper) {
        clientDto = clientMapper.mapEntityToDto(clientEntity);
    }

    @Test
    void createClientTest() {
        Mockito.doReturn(clientEntity).when(clientRepository).save(any(Client.class));
        Assertions.assertEquals(clientDto, clientService.create(clientDto));
    }

    @Test
    void deleteClientTest() {
        long entityId = 1L;
        clientService.delete(entityId);
        Mockito.verify(clientRepository).deleteById(entityId);
    }
    @Test
    void getAllClientTest() {
        Mockito.doReturn(List.of(clientEntity)).when(clientRepository).findAll();
        List<ClientDto> actual = clientService.getAll();
        Mockito.verify(clientRepository).findAll();
        assertEquals(1, actual.size());
        assertEquals(clientDto, actual.get(0));
    }
}

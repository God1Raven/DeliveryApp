package com.example.deliveryapp.service;

import com.example.deliveryapp.dto.ClientDto;
import com.example.deliveryapp.mapper.ClientMapper;
import com.example.deliveryapp.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClientService implements BaseService<ClientDto> {
    private ClientRepository clientRepository;
    private ClientMapper clientMapper;

    @Autowired
    public ClientService(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    public ClientDto create(ClientDto clientDto) {
        return clientMapper.mapEntityToDto(clientRepository.save(clientMapper.mapDtoToEntity(clientDto)));
    }

    public ClientDto update(ClientDto clientDto) {
        return clientMapper.mapEntityToDto(clientRepository.save(clientMapper.mapDtoToEntity(clientDto)));
    }

    public ClientDto get(Long id) {
        return clientRepository.findById(id).map(x -> clientMapper.mapEntityToDto(x)).orElse(null);
    }

    public void delete(Long id) {
        clientRepository.deleteById(id);
    }
}

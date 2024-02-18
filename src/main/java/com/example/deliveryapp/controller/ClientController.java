package com.example.deliveryapp.controller;

import com.example.deliveryapp.dto.ClientDto;
import com.example.deliveryapp.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController extends CrudController<ClientDto, ClientService> {

    @Autowired
    public ClientController(ClientService clientService) {
        this.baseService = clientService;
    }

}



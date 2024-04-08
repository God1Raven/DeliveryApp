package com.example.deliveryapp.controller;

import com.example.deliveryapp.dto.ClientDto;
import com.example.deliveryapp.service.ClientService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
@SecurityRequirement(name = "bearerAuth")
@PreAuthorize("hasRole('CLIENT')")
public class ClientController extends CrudController<ClientDto, ClientService> {

    @Autowired
    public ClientController(ClientService clientService) {
        this.baseService = clientService;
    }
}

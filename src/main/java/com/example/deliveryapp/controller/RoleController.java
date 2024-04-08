package com.example.deliveryapp.controller;

import com.example.deliveryapp.security.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Role")
@RequiredArgsConstructor
@Tag(name = "auth")
public class RoleController {

    private final UserService service;

    @GetMapping("get-admin")
    @Operation(summary = "Получить роль ")
    public void getClient() {
        service.getClient();
    }
}

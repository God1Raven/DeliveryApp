package com.example.deliveryapp.controller;

import com.example.deliveryapp.dto.AdminDto;
import com.example.deliveryapp.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@PreAuthorize("hasRole('CLIENT')")
public class AdminController extends CrudController<AdminDto, AdminService>{
    @Autowired
    public AdminController(AdminService adminService) {
        this.baseService = adminService;
    }
}

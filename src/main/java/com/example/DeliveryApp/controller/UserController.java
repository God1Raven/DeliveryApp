package com.example.DeliveryApp.controller;

import com.example.DeliveryApp.dto.UserDto;
import com.example.DeliveryApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController extends CrudController<UserDto> {

    @Autowired
    public UserController(UserService userService) {
        this.baseService = userService;
    }
}



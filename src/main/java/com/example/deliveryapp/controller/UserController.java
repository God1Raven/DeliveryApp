package com.example.deliveryapp.controller;

import com.example.deliveryapp.dto.UserDto;
import com.example.deliveryapp.service.UserService;
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



package com.example.DeliveryApp.controller;

import com.example.DeliveryApp.dto.UserDto;
import com.example.DeliveryApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto user = userService.createUser(userDto);
        return ResponseEntity.ok(user);
    }
    @RequestMapping(method = RequestMethod.PUT)
    public UserDto updateUser(@RequestBody UserDto userDto){
        return userService.updateUser(userDto);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public UserDto getUserById(@PathVariable("id") Long id){
        return userService.getUser(id);
    }
    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteUserById(Long id){
        userService.deleteUser(id);
    }
}

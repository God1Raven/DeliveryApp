package com.example.DeliveryApp.service;

import com.example.DeliveryApp.dto.UserDto;
import com.example.DeliveryApp.mapper.UserMapper;
import com.example.DeliveryApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService implements BaseService<UserDto> {
    private UserRepository userRepository;
    private UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDto create(UserDto userDto) {
        return userMapper.mapEntityToDto(userRepository.save(userMapper.mapDtoToEntity(userDto)));
    }

    public UserDto update(UserDto userDto) {
        return userMapper.mapEntityToDto(userRepository.save(userMapper.mapDtoToEntity(userDto)));
    }

    public UserDto get(Long id) {
        return userRepository.findById(id).map(x -> userMapper.mapEntityToDto(x)).orElse(null);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}

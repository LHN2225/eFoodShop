package com.example.shipper.controller;

import com.example.shipper.dto.UserDto;
import com.example.shipper.mapper.UserMapper;
import com.example.shipper.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController3 {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/mapper/user")
    public List<UserDto> getUsers() {
        return userMapper.entityListToDtoList(userRepository.findAll());
    }

}

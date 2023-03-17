package com.example.shipper.service.impl;

import com.example.shipper.config.AppConfig;
import com.example.shipper.dto.UserDto;
import com.example.shipper.entity.User;
import com.example.shipper.mapper.UserMapper;
import com.example.shipper.repository.UserRepository;
import com.example.shipper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AppConfig appConfig;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserDto> findAll() {
        return userMapper.entityListToDtoList(userRepository.findAll());
    }

    @Override
    public UserDto findById() {
        return userMapper.entityToDto(userRepository.findById(appConfig.shipperId).orElse(null));
    }

    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

    @Override
    public User saveUser(User user) {
        return null;
    }

    @Override
    public int updateProfile(Long id, String fullname, String phone) {
        return userRepository.updateProfile(id, fullname, phone);
    }
}

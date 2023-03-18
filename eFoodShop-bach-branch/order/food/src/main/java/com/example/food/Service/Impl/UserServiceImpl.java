package com.example.food.Service.Impl;

import com.example.food.DTO.OrderInfoDTO;
import com.example.food.Repository.UserRepository;
import com.example.food.Service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<OrderInfoDTO> getOrderShippingStatusByUserId(Long id) {
        return userRepository.findOrderShippingStatusByUserId(id);
    }
}


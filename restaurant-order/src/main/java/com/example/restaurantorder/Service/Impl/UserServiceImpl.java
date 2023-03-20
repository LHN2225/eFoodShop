package com.example.restaurantorder.Service.Impl;

import com.example.restaurantorder.DTO.OrderInfoDTO;
import com.example.restaurantorder.Repository.UserRepository;
import com.example.restaurantorder.Service.UserService;
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


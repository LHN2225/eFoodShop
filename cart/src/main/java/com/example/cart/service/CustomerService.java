package com.example.cart.service;

import com.example.cart.dto.UserDto;
import com.example.cart.entity.User;

public interface CustomerService {
    UserDto save(UserDto customerDto);

    User findByEmail(String email);
}

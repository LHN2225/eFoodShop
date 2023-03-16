package com.example.managerinfo.service;

import com.example.managerinfo.dto.FoodCartDto;

public interface CartService {
    FoodCartDto addToCart(Long customerId, Long foodId) throws Exception;
    Long getQuantityInCartByCustomerId(Long customerId);
}

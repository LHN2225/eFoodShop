package com.example.cart.service;

import com.example.cart.dto.FoodCartDto;
import com.example.cart.entity.FoodCart;

import java.util.List;

public interface FoodCartService {
    List<FoodCartDto> findByCartId(Long cartId);
    Long totalItems(Long cartId);
    Long getTotalPrice(Long cartId);
}

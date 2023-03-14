package com.example.cart.service;

import com.example.cart.dto.FoodDto;
import com.example.cart.entity.Food;

import java.util.List;
import java.util.Optional;

public interface FoodService {
    List<FoodDto> findAll();
    Optional<Food> getFoodById(Long foodId);
}

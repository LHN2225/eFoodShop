package com.example.cart.service;

import com.example.cart.dto.FoodDto;

import java.util.List;

public interface FoodService {
    List<FoodDto> findAll();

}

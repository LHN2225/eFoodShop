package com.example.managerinfo.service;

import com.example.managerinfo.dto.FoodDto;

import java.util.List;

public interface FoodService {
    List<FoodDto> findAll();
}

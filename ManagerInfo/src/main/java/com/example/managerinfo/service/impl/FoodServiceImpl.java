package com.example.managerinfo.service.impl;

import com.example.managerinfo.dto.FoodDto;
import com.example.managerinfo.entity.Food;
import com.example.managerinfo.mapper.FoodMapper;
import com.example.managerinfo.repository.FoodRepository;
import com.example.managerinfo.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private FoodMapper foodMapper;

    @Override
    public List<FoodDto> findAll() {
        List<FoodDto> listFoodDto = new ArrayList<>();
        Iterable<Food> listFoodEntity = foodRepository.findAll();
        for(Food foodEntity: listFoodEntity) {
            listFoodDto.add(foodMapper.INSTANCE.entityToDto(foodEntity));
        }
        return listFoodDto;
    }
}

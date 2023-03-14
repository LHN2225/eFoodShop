package com.example.cart.service.impl;

import com.example.cart.dto.FoodDto;
import com.example.cart.entity.Food;
import com.example.cart.mapper.FoodMapper;
import com.example.cart.repository.FoodReposiroty;
import com.example.cart.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FoodServiceImpl implements FoodService {
    @Autowired
    private FoodReposiroty foodReposiroty;
    @Override
    public List<FoodDto> findAll() {
        List<Food> products = foodReposiroty.findAll();
        List<FoodDto> productDtoList = transfer(products);
        return productDtoList;
    }

    @Override
    public Optional<Food> getFoodById(Long foodId) {
        return foodReposiroty.findById(foodId);
    }

    private List<FoodDto> transfer(List<Food> products){
        List<FoodDto> productDtoList = new ArrayList<>();
        for(Food product : products){
            FoodDto productDto = FoodMapper.INSTANCE.entityToDto(product);
            productDtoList.add(productDto);
        }
        return productDtoList;
    }
}

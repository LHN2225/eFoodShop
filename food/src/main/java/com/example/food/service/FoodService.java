package com.example.food.service;

import com.example.food.dto.CreateFoodDto;
import com.example.food.dto.FoodDetailDto;
import com.example.food.entity.Food;
import com.example.food.viewmodel.FoodListViewModel;

import java.io.IOException;

public interface FoodService {
    FoodListViewModel viewAllFood(int pageNumber);

    void saveFood(Food food) throws IOException;

    void deleteFood(long id);

    FoodDetailDto viewFoodDetail(long id);

    void updateFoodWithoutImage(Food food);

    void updateFoodWithNewImage(Food food);
}

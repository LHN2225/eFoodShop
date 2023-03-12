package com.example.food.service.impl;

import com.example.food.dto.FoodDetailDto;
import com.example.food.entity.Food;
import com.example.food.repository.FoodRepository;
import com.example.food.service.FoodService;
import com.example.food.viewmodel.FoodListViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    FoodRepository foodRepository;

    @Override
    public FoodListViewModel viewAllFood(int pageNumber) {
        return new FoodListViewModel(
                foodRepository.getTotalPageAllFood(),
                pageNumber,
                foodRepository.getAllFood(pageNumber)
        );
    }

    @Override
    public void saveFood(Food food) throws IOException {
        foodRepository.saveFood(food);
    }

    @Override
    public void deleteFood(long id) {
        foodRepository.deleteFood(id);
    }

    @Override
    public FoodDetailDto viewFoodDetail(long id) {
        try {
            return foodRepository.viewFoodDetail(id);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void updateFoodWithoutImage(Food food) {
        foodRepository.updateFoodWithoutImage(food);
    }

    @Override
    public void updateFoodWithNewImage(Food food) {
        foodRepository.updateFoodWithNewImage(food);
    }
}

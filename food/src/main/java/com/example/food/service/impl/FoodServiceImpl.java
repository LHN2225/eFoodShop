package com.example.food.service.impl;

import com.example.food.repository.FoodRepository;
import com.example.food.service.FoodService;
import com.example.food.viewmodel.FoodListViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}

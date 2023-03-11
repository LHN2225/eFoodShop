package com.example.food.service;

import com.example.food.viewmodel.FoodListViewModel;

public interface FoodService {
    FoodListViewModel viewAllFood(int pageNumber);
}

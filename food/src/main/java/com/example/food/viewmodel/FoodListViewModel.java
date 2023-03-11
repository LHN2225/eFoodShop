package com.example.food.viewmodel;

import com.example.food.dto.FoodRecordDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class FoodListViewModel {
    int totalPage;
    int currentPage;
    List<FoodRecordDto> foodList;
}

package com.example.food.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateFoodDto {
    String name;
    String description;
    Media imageUrl;
    Float price;
}

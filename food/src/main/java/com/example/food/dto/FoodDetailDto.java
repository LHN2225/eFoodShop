package com.example.food.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodDetailDto {
    Long id;
    String name;
    String description;
    String imageLink;
    Float price;
}

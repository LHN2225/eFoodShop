package com.example.food.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FoodRecordDto {
    Long id;
    String name;
    String imageLink;
    Float price;
}

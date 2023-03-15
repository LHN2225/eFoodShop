package com.example.food.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderFoodDTO {
    private Long foodId;

    private String foodName;

    private Float foodQuantity;

    private Float fixedPrice;

    private Float sum;
}

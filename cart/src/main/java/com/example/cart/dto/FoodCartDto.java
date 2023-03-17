package com.example.cart.dto;

import com.example.cart.entity.Food;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodCartDto {
    private Long id;
    private Food food;
    private Long cartId;
    private Long foodQuantity;
    private float fixedPrice;
}

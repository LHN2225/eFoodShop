package com.example.cart.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodCartDto {
    private Long id;
    private Long foodId;
    private Long cartId;
    private Long foodQuantity;
    private float fixedPrice;
}

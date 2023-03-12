package com.example.food.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodCartDetailDTO {
    Long foodCartId;
    Long foodId;
    Long cartId;
    Float foodQuantity;
    Float fixedPrice;
    String status;
}

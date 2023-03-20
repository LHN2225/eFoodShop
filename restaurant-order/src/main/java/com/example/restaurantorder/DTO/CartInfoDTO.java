package com.example.restaurantorder.DTO;

import lombok.Data;

@Data
public class CartInfoDTO {
    private String foodName;
    private Long foodQuantity;
    private float fixedPrice;
    public CartInfoDTO(String foodName, Long foodQuantity, float fixedPrice) {
        this.foodName = foodName;
        this.foodQuantity = foodQuantity;
        this.fixedPrice = fixedPrice;
    }
}

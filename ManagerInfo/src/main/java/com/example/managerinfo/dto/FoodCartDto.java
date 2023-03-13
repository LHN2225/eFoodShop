package com.example.managerinfo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FoodCartDto {
    private Long id;
    private Long foodId;
    private Long cartId;
    private Long foodQuantity;
    private float fixedPrice;
}

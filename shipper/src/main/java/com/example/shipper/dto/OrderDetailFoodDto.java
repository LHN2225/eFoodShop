package com.example.shipper.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderDetailFoodDto {
    private String name;
    private int quantity;
    private float cost;
}

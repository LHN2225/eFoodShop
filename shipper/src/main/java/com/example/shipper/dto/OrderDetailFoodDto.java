package com.example.shipper.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailFoodDto {
    private String name;
    private int quantity;
    private float cost;
}

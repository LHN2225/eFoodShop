package com.example.food.DTO;

import lombok.Data;

@Data
public class OrderRequestDTO {
    private Long cartId;
    private String address;
}

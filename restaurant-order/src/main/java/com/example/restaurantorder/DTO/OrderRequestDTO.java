package com.example.restaurantorder.DTO;

import lombok.Data;

@Data
public class OrderRequestDTO {
    private Long cartId;
    private String address;
}

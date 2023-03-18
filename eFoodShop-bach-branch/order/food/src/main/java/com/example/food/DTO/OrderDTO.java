package com.example.food.DTO;

import lombok.Data;

@Data
public class OrderDTO {
    private Long id;
    private Long cartId;
    private String address;
    private Long shipperId;
    private String shippingStatus;
}
package com.example.food.DTO;

import lombok.Data;

@Data
public class OrderInfoDTO {
    private Long id;
    private String shippingStatus;
    public OrderInfoDTO (Long id, String shippingStatus) {
        this.id = id;
        this.shippingStatus = shippingStatus;
    }
}

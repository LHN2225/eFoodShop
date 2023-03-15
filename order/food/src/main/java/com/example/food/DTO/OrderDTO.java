package com.example.food.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Long orderId;
    private Long cartId;
    private Long shipperId;
    private String shippingStatus;
    private Float total;

    public OrderDTO(Long orderId, Long cartId, Long shipperId, Float total, String shippingStatus) {
        this.orderId = orderId;
        this.cartId = cartId;
        this.shipperId = shipperId;
        this.total = total;
        this.shippingStatus = shippingStatus;
    }
}

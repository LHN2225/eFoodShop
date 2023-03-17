package com.example.virtual_food_cart_order.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class OrderDetailDto {
    @NonNull
    private Long orderId;

    @NonNull
    private Timestamp createdDate;

    @NonNull
    private String address;

    @NonNull
    private String customerFullname;

    @NonNull
    private String shipperFullname;

    private List<OrderDetailFoodDto> foods;
}

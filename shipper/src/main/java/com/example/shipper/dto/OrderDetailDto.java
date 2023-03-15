package com.example.shipper.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@RequiredArgsConstructor
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

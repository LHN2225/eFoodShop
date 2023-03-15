package com.example.shipper.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class OrderDetailDto {
    private Long orderId;
    private Timestamp createdDate;
    private String address;
    private String customerFullname;
    private String shipperFullname;
    private String foodName;
    private int food_quantity;
    private float cost;
}

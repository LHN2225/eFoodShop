package com.example.shipper.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class OrderDto {
    private Long id;
    private Timestamp createdDate;
    private String address;
}

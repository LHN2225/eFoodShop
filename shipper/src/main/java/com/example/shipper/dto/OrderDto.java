package com.example.shipper.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class OrderDto {
    private Long id;
    private Timestamp createdDate;
    private String address;
}

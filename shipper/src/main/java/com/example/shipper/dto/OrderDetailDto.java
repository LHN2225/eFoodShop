package com.example.shipper.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
public class OrderDetailDto {
    private Long orderId;
    private Timestamp createdDate;
    private String address;
    private String customerFullname;
    private String shipperFullname;
}

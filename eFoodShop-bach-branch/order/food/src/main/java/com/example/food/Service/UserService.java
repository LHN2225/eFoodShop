package com.example.food.Service;

import com.example.food.DTO.OrderInfoDTO;

import java.util.List;

public interface UserService {
    List<OrderInfoDTO> getOrderShippingStatusByUserId(Long id);
}

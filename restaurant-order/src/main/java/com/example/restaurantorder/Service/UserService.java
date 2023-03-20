package com.example.restaurantorder.Service;

import com.example.restaurantorder.DTO.OrderInfoDTO;

import java.util.List;

public interface UserService {
    List<OrderInfoDTO> getOrderShippingStatusByUserId(Long id);
}

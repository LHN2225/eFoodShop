package com.example.food.Service;

import com.example.food.DTO.OrderDTO;
import com.example.food.DTO.OrderRequestDTO;
import com.example.food.Entity.Order;

public interface OrderService {
    public OrderDTO createOrder(OrderRequestDTO orderRequestDTO);
}

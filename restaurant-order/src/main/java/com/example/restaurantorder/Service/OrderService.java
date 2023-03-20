package com.example.restaurantorder.Service;

import com.example.restaurantorder.DTO.CartInfoDTO;
import com.example.restaurantorder.DTO.OrderDTO;
import com.example.restaurantorder.DTO.OrderRequestDTO;
import com.example.restaurantorder.Entity.Order;

import java.util.List;

public interface OrderService {
    public OrderDTO createOrder(OrderRequestDTO orderRequestDTO);
    OrderDTO findById(Long id);
    List<CartInfoDTO> findFoodByCartId(Long orderId);
}

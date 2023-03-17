package com.example.virtual_food_cart_order.service;

import com.example.virtual_food_cart_order.dto.OrderDetailFoodDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderDetailFoodService {
    List<OrderDetailFoodDto> getFoodsByOrderId(Long orderId);
}

package com.example.virtual_food_cart_order.service;

import com.example.virtual_food_cart_order.dto.OrderDetailDto;
import org.springframework.stereotype.Service;

@Service
public interface OrderDetailService {
    OrderDetailDto getOrderDetailById(Long orderId);
}

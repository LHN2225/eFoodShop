package com.example.virtual_food_cart_order.service.impl;

import com.example.virtual_food_cart_order.dto.OrderDetailFoodDto;
import com.example.virtual_food_cart_order.repository.OrderDetailFoodRepository;
import com.example.virtual_food_cart_order.service.OrderDetailFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailFoodServiceImpl implements OrderDetailFoodService {

    @Autowired
    private OrderDetailFoodRepository orderDetailFoodRepository;

    @Override
    public List<OrderDetailFoodDto> getFoodsByOrderId(Long orderId) {
        return orderDetailFoodRepository.findByOrderId(orderId);
    }
}

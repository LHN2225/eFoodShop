package com.example.food.Service;

import com.example.food.DTO.OrderFoodDTO;
import com.example.food.Repository.FoodCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodCartService {
    @Autowired
    private FoodCartRepository foodCartRepository;

    public List<OrderFoodDTO> getOrderFoodsByCustomerIdAndOrderId(Long customerId, Long orderId) {
        return foodCartRepository.getOrderFoodsByCustomerIdAndOrderId(customerId, orderId);
    }
}

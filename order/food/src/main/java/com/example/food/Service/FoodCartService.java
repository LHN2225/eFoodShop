package com.example.food.Service;

import com.example.food.DTO.FoodCartDTO;
import com.example.food.DTO.FoodCartDetailDTO;
import com.example.food.Entity.Order;
import com.example.food.Repository.FoodCartRepository;
import com.example.food.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodCartService {

    @Autowired
    private FoodCartRepository foodCartRepository;

    @Autowired
    private OrderRepository orderRepository;

    public FoodCartDetailDTO updateFoodCart(FoodCartDetailDTO foodCartDetailDTO) {
        foodCartRepository.updateFoodCart(foodCartDetailDTO.getFoodCartId(), foodCartDetailDTO.getFoodQuantity(), foodCartDetailDTO.getFixedPrice());
        if ("buying".equals(foodCartDetailDTO.getStatus())) {
            boolean exists = orderRepository.existsById(foodCartDetailDTO.getCartId());
            if (!exists) {
                Order order = new Order();
                order.setCartId(foodCartDetailDTO.getCartId());
                order.setShippingStatus("pending");
                orderRepository.save(order);
            }
        }
        return foodCartDetailDTO;
    }

    public List<FoodCartDTO> findFoodCartDTOByCustomerId(Long customerId) {
        return foodCartRepository.findFoodCartDTOByCustomerId(customerId);
    }
}
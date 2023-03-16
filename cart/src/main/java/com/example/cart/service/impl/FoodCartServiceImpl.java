package com.example.cart.service.impl;

import com.example.cart.entity.FoodCart;
import com.example.cart.repository.FoodCartRepository;
import com.example.cart.service.FoodCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodCartServiceImpl implements FoodCartService {
    @Autowired
    private FoodCartRepository foodCartRepository;
    @Override
    public List<FoodCart> findByCartId(Long cartId) {
        return foodCartRepository.findByCartId(cartId);
    }

    @Override
    public Long totalItems(Long cartId) {
        List<FoodCart> foodCartList = foodCartRepository.findByCartId(cartId);
        Long total = 0L;
        for (FoodCart food : foodCartList){
            total += food.getFoodQuantity();
        }
        return total;
    }

    @Override
    public Long getTotalPrice(Long cartId) {
        List<FoodCart> foodCartList = foodCartRepository.findByCartId(cartId);
        Long total = 0L;
        for (FoodCart food : foodCartList){
            total = (long) (total + (Long)food.getFoodQuantity() * food.getFixedPrice());
        }
        return total;
    }
}

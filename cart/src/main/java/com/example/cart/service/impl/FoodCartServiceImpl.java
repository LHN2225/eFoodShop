package com.example.cart.service.impl;

import com.example.cart.dto.FoodCartDto;
import com.example.cart.entity.Food;
import com.example.cart.entity.FoodCart;
import com.example.cart.mapper.FoodCartMapper;
import com.example.cart.repository.FoodCartRepository;
import com.example.cart.repository.FoodReposiroty;
import com.example.cart.service.FoodCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodCartServiceImpl implements FoodCartService {
    @Autowired
    private FoodCartRepository foodCartRepository;

    @Autowired
    private FoodCartMapper foodCartMapper;

    @Autowired
    private FoodReposiroty foodReposiroty;

    @Override
    public List<FoodCartDto> findByCartId(Long cartId) {
        List<FoodCart> foodCartList = foodCartRepository.findByCartId(cartId);
        List<FoodCartDto> foodCartDtoList = new ArrayList<>();

        for (FoodCart foodCart: foodCartList) {
            FoodCartDto newFoodCartDto = foodCartMapper.INSTANCE.entityToDto(foodCart);
            newFoodCartDto.setFood(foodReposiroty.findById(foodCart.getFoodId()).get());
            foodCartDtoList.add(newFoodCartDto);
        }
        return foodCartDtoList;
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

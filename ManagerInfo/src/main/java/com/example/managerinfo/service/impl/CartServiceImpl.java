package com.example.managerinfo.service.impl;

import com.example.managerinfo.dto.FoodCartDto;
import com.example.managerinfo.entity.Cart;
import com.example.managerinfo.entity.Food;
import com.example.managerinfo.entity.FoodCart;
import com.example.managerinfo.mapper.FoodCartMapper;
import com.example.managerinfo.repository.CartRepository;
import com.example.managerinfo.repository.FoodCartRepository;
import com.example.managerinfo.repository.FoodRepository;
import com.example.managerinfo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private FoodCartRepository foodCartRepository;

    @Autowired
    private FoodCartMapper foodCartMapper;


    @Override
    public FoodCartDto addToCart(Long customerId, Long foodId) throws Exception {
        Cart currentCart = cartRepository.findByCustomerIdAndIsDeleted(customerId, false);

        if (currentCart == null) {
            currentCart = new Cart();
            currentCart.setCustomerId(customerId);
            currentCart = cartRepository.save(currentCart);
        }

        Optional<Food> buyFood = foodRepository.findById(foodId);
        if (buyFood.isEmpty()) {
            throw new Exception("There is no food id!");
        }

        FoodCart addFoodToCart = foodCartRepository.findByFoodIdAndCartId(foodId, currentCart.getId());

        if (addFoodToCart != null) {
            addFoodToCart.setFoodQuantity(addFoodToCart.getFoodQuantity() + 1);
            addFoodToCart.setFixedPrice(addFoodToCart.getFixedPrice());
        } else {
            addFoodToCart = new FoodCart();
            addFoodToCart.setCartId(currentCart.getId());
            addFoodToCart.setFoodId(buyFood.get().getId());
            addFoodToCart.setFixedPrice(buyFood.get().getPrice());
            addFoodToCart.setFoodQuantity(1L);
        }

        addFoodToCart = foodCartRepository.save(addFoodToCart);

        return foodCartMapper.INSTANCE.entityToDto(addFoodToCart);
    }

    @Override
    public Long getQuantityInCartByCustomerId(Long customerId) {
        Cart currentCart = cartRepository.findByCustomerIdAndIsDeleted(customerId, false);
        if (currentCart == null) {
            return 0L;
        }

        List<FoodCart> listFoodInCart = foodCartRepository.findAllByCartId(currentCart.getId());
        if (listFoodInCart.isEmpty()) {
            return 0L;
        }

        Long quantity = 0L;
        for (FoodCart foodCart: listFoodInCart) {
            quantity += foodCart.getFoodQuantity();
        }
        return quantity;
    }
}

package com.example.cart.service;

import com.example.cart.entity.Cart;
import com.example.cart.entity.Food;
import com.example.cart.entity.FoodCart;
import com.example.cart.entity.User;

import java.util.List;
import java.util.Optional;

public interface ShoppingCartService {
    Cart updateItemInCart(Optional<Food> product, Long quantity, User customer);
    Cart deleteItemFromCart(Optional<Food> product, User customer);
    Cart findByCustomerId(Long customerId);
    List<FoodCart> getFoodsInCart(Long cartId);
}

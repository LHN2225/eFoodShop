package com.example.cart.service.impl;

import com.example.cart.entity.Cart;
import com.example.cart.entity.Food;
import com.example.cart.entity.FoodCart;
import com.example.cart.entity.User;
import com.example.cart.repository.CartRepository;
import com.example.cart.repository.FoodCartRepository;
import com.example.cart.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private FoodCartRepository foodCartRepository;
    @Override
    public Cart updateItemInCart(Optional<Food> product, Long quantity, User customer) {
        Long cartId = cartRepository.findByCustomerIdAndIsDeleted(customer.getId(), false).getId();
        List<FoodCart> cartItems = foodCartRepository.findByCartId(cartId);


        FoodCart item = findFood(cartItems, product.get().getId());

        item.setFoodQuantity(quantity);

        foodCartRepository.save(item);
        return cartRepository.findByCustomerIdAndIsDeleted(customer.getId(), false);
    }

    @Override
    public Cart deleteItemFromCart(Optional<Food> product, User customer) {
        Long cartId = cartRepository.findByCustomerIdAndIsDeleted(customer.getId(), false).getId();
        List<FoodCart> cartItems = foodCartRepository.findByCartId(cartId);

        FoodCart item = findFood(cartItems, product.get().getId());
        cartItems.remove(item);
        foodCartRepository.delete(item);
        return cartRepository.findByCustomerIdAndIsDeleted(customer.getId(), false);
    }

    @Override
    public Cart findByCustomerId(Long customerId) {
        return cartRepository.findByCustomerIdAndIsDeleted(customerId, false);
    }

    @Override
    public List<FoodCart> getFoodsInCart(Long cartId) {
        return foodCartRepository.findByCartId(cartId);
    }

    private FoodCart findFood(List<FoodCart> cartItems, Long productId) {
        if (cartItems == null) {
            return null;
        }
        FoodCart cartItem = null;

        for (FoodCart item : cartItems) {
            if (item.getFoodId() == productId) {
                cartItem = item;
            }
        }
        return cartItem;
    }
}

package com.example.restaurantorder.Service.Impl;

import com.example.restaurantorder.DTO.CartInfoDTO;
import com.example.restaurantorder.Repository.CartRepository;
import com.example.restaurantorder.Service.CartService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;

    public CartServiceImpl(CartRepository CartRepository) {
        this.cartRepository = CartRepository;
    }

    @Override
    public List<CartInfoDTO> getCartInfoByCartId(Long id) {
        return cartRepository.findCartInfoByCartId(id);
    }
}

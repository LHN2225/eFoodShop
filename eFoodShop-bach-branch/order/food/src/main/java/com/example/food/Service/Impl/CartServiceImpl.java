package com.example.food.Service.Impl;

import com.example.food.DTO.CartInfoDTO;
import com.example.food.Repository.CartRepository;
import com.example.food.Service.CartService;
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

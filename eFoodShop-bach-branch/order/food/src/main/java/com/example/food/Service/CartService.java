package com.example.food.Service;

import com.example.food.DTO.CartInfoDTO;

import java.util.List;

public interface CartService {
    List<CartInfoDTO> getCartInfoByCartId(Long id);

}

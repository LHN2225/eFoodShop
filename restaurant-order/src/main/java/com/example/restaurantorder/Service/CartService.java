package com.example.restaurantorder.Service;

import com.example.restaurantorder.DTO.CartInfoDTO;

import java.util.List;

public interface CartService {
    List<CartInfoDTO> getCartInfoByCartId(Long id);

}

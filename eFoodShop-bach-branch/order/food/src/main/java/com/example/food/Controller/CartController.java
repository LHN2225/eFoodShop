package com.example.food.Controller;

import com.example.food.DTO.CartInfoDTO;
import com.example.food.Service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/carts")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/{id}/name-foodQuantity-fixedPrice")
    public ResponseEntity<List<CartInfoDTO>> getCartInfoByCartId(@PathVariable Long id) {
        List<CartInfoDTO> results = cartService.getCartInfoByCartId(id);
        if (!results.isEmpty()) {
            return ResponseEntity.ok(results);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
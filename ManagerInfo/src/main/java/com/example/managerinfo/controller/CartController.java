package com.example.managerinfo.controller;

import com.example.managerinfo.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/manager-info/cart/")
@Slf4j
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("add-to-cart/{foodId}")
    public String addToCart(@PathVariable Long foodId, Model model) throws Exception {
        Long customerId = Long.valueOf(2);
        cartService.addToCart(customerId, foodId);
        return "CustomerMenu";
    }
}

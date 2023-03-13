package com.example.cart.controller;

import com.example.cart.entity.Cart;
import com.example.cart.entity.User;
import com.example.cart.service.CustomerService;
import com.example.cart.service.FoodService;
import com.example.cart.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
public class CartController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private FoodService foodService;
    @Autowired
    private ShoppingCartService cartService;

    @GetMapping("/cart")
    public String cart(Model model, HttpSession session){
//        if(principal == null){
//            return "redirect:/login";
//        }
//        String username = principal.getName();
        User customer = customerService.findByUsername("user1");
        Cart shoppingCart = (Cart) cartService.getFoodsInCart(cartService.findByCustomerId(customer.getId()).getId());
        if(shoppingCart == null){
            model.addAttribute("check", "No item in your cart");
        }
        session.setAttribute("totalItems", 3);
        model.addAttribute("subTotal", 5);
        model.addAttribute("shoppingCart", shoppingCart);
        return "cart";
    }

}

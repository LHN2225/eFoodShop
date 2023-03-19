package com.example.cart.controller;

import com.example.cart.dto.FoodCartDto;
import com.example.cart.entity.Cart;
import com.example.cart.entity.Food;
import com.example.cart.entity.FoodCart;
import com.example.cart.entity.User;
import com.example.cart.service.CustomerService;
import com.example.cart.service.FoodCartService;
import com.example.cart.service.FoodService;
import com.example.cart.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
public class CartController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private FoodService foodService;
    @Autowired
    private ShoppingCartService cartService;
    @Autowired
    private FoodCartService foodCartService;

    private final String email = "customer1@gmail.com";



    @GetMapping("/cart")
    public String cart(Model model, HttpSession session){
        User customer = customerService.findByEmail(email);
        Long customerId = customer.getId();
        Cart cart = cartService.findByCustomerId(customerId);
        if(cart == null){
            model.addAttribute("check", "No item in your cart");
            return "cart";
        }
        List<FoodCartDto> shoppingCart = foodCartService.findByCartId(cart.getId());

        session.setAttribute("totalItems", foodCartService.totalItems(cart.getId()));
        model.addAttribute("subTotal", foodCartService.getTotalPrice(cart.getId()));
        model.addAttribute("shoppingCart", shoppingCart);
        model.addAttribute("shipCost", 0);
        return "cart";
    }

    @RequestMapping(value = "/update-cart", method = RequestMethod.POST, params = "action=update")
    public String updateCart(@RequestParam("quantity") Long quantity,
                             @RequestParam("id") Long productId,
                             Model model
    ){
            User customer = customerService.findByEmail(email);
            Optional<Food> product = foodService.getFoodById(productId);
            Cart cart = cartService.updateItemInCart(product, quantity, customer);

//            List<FoodCartDto> shoppingCart = foodCartService.findByCartId(cart.getId());
//            model.addAttribute("shoppingCart", shoppingCart);
            return "success";
    }
    @RequestMapping(value = "/update-cart", method = RequestMethod.POST, params = "action=delete")
    public String deleteItemFromCart(@RequestParam("id") Long productId,
                                     Model model){

            User customer = customerService.findByEmail(email);
            Optional<Food> product = foodService.getFoodById(productId);
            Cart cart = cartService.deleteItemFromCart(product, customer);
//            model.addAttribute("shoppingCart", cart);
            return "success";


    }
}

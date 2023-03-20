package com.example.restaurantorder.Controller;

import com.example.restaurantorder.DTO.OrderInfoDTO;
import com.example.restaurantorder.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}/order-shipping-status")
    public String getOrderShippingStatusByUserId(@PathVariable Long id, Model model) {
        List<OrderInfoDTO> results = userService.getOrderShippingStatusByUserId(id);
        model.addAttribute("orders", results);
        if (!results.isEmpty()) {
            return "in-progress-order";
        } else {
            return null;
        }
    }
}

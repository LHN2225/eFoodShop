package com.example.food.Controller;

import com.example.food.DTO.OrderInfoDTO;
import com.example.food.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}/order-shipping-status")
    public ResponseEntity<List<OrderInfoDTO>> getOrderShippingStatusByUserId(@PathVariable Long id) {
        List<OrderInfoDTO> results = userService.getOrderShippingStatusByUserId(id);
        if (!results.isEmpty()) {
            return ResponseEntity.ok(results);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

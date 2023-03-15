package com.example.food.Controller;

import com.example.food.DTO.OrderDTO;
import com.example.food.DTO.OrderFoodDTO;
import com.example.food.DTO.OrderInfoDTO;
import com.example.food.Service.FoodCartService;
import com.example.food.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private FoodCartService foodCartService;

    @PostMapping("")
    public ResponseEntity<OrderDTO> createOrder(@RequestParam Long cartId) {
        OrderDTO orderDTO = orderService.createOrder(cartId);
        if (orderDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(orderDTO);
    }

    @GetMapping("")
    public ResponseEntity<List<OrderInfoDTO>> getOrderByCustomerId(@RequestParam Long customerId) {
        List<OrderInfoDTO> orderList = orderService.getOrderByCustomerId(customerId);
        if (orderList == null || orderList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(orderList);
    }

    @GetMapping("/{orderId}/foods")
    public ResponseEntity<List<OrderFoodDTO>> getOrderFoodsByCustomerIdAndOrderId(@RequestParam Long customerId,
                                                                                  @PathVariable Long orderId) {
        List<OrderFoodDTO> orderFoods = foodCartService.getOrderFoodsByCustomerIdAndOrderId(customerId, orderId);
        if (orderFoods == null || orderFoods.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(orderFoods);
    }
}
package com.example.food.Controller;

import com.example.food.DTO.OrderDTO;
import com.example.food.DTO.OrderRequestDTO;
import com.example.food.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
        OrderDTO orderDTO = orderService.createOrder(orderRequestDTO);
        return ResponseEntity.ok(orderDTO);
    }

//    @GetMapping("/{orderId}")
//    public ResponseEntity<OrderDTO> getOrderById(@PathVariable Long orderId) {
//        OrderDTO orderDTO = orderService.getOrderById(orderId);
//        return ResponseEntity.ok(orderDTO);
//    }
//
//    @GetMapping("/customer/{customerId}")
//    public ResponseEntity<List<OrderDTO>> getOrdersByCustomerId(@PathVariable Long customerId) {
//        List<OrderDTO> orderDTOs = orderService.getOrdersByCustomerId(customerId);
//        return ResponseEntity.ok(orderDTOs);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<OrderDTO>> getAllOrders() {
//        List<OrderDTO> orderDTOs = orderService.getAllOrders();
//        return ResponseEntity.ok(orderDTOs);
//    }
}
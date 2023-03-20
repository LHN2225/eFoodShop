package com.example.restaurantorder.Controller;

import com.example.restaurantorder.DTO.CartInfoDTO;
import com.example.restaurantorder.DTO.OrderDTO;
import com.example.restaurantorder.DTO.OrderRequestDTO;
import com.example.restaurantorder.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderRequestDTO orderRequestDTO, Model model) {
        OrderDTO orderDTO = orderService.createOrder(orderRequestDTO);
//        model.addAttribute("orderDetail", orderDTO);
        return ResponseEntity.ok(orderDTO);
    }

    @GetMapping("/{orderId}")
    public String getOrderById(@PathVariable Long orderId, Model model) {
        OrderDTO orderDTO = orderService.findById(orderId);
        List<CartInfoDTO> foods = orderService.findFoodByCartId(orderId);
        model.addAttribute("foods", foods);
        model.addAttribute("orderDetail", orderDTO);
        return "order-detail";
    }


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
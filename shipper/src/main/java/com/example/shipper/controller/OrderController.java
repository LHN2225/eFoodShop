package com.example.shipper.controller;

import com.example.shipper.entity.Order;
import com.example.shipper.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/not-busy")
    public ResponseEntity<List<Order>> getOrderThatNotBusy() {
        try {
            List<Order> orders = orderService.getOrderThatNotBusy();
            if (orders.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(orders, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/shipper")
    public ResponseEntity<Integer> receiveOrderByShipper(@RequestParam Long shipperId, @RequestParam Long orderId) {
        try {
            int response = orderService.receiveOrderByShipper(shipperId, orderId);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

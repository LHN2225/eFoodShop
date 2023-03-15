package com.example.shipper.controller;

import com.example.shipper.dto.OrderDetailDto;
import com.example.shipper.entity.Order;
import com.example.shipper.service.OrderDetailFoodService;
import com.example.shipper.service.OrderDetailService;
import com.example.shipper.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    // Test for shipper id before authentication and authorization handling by security
    public Long shipper_id_test = 1L;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private OrderDetailFoodService orderDetailFoodService;

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

    @GetMapping("/in-progress")
    public ResponseEntity<List<Order>> getInProgressOrder() {
        try {
            List<Order> orders = orderService.getInProgressOrders(shipper_id_test);
            if (orders.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(orders, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/delivered")
    public ResponseEntity<List<Order>> getDeliveredOrder() {
        try {
            List<Order> orders = orderService.getDeliveredOrders(shipper_id_test);
            if (orders.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(orders, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDetailDto> getOrderById(@PathVariable Long orderId) {
        try {
            OrderDetailDto orderDetail = orderDetailService.getOrderDetailById(orderId);
            if (orderDetail == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(orderDetail, HttpStatus.OK);
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

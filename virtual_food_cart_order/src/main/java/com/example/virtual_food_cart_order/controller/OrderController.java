package com.example.virtual_food_cart_order.controller;

import com.example.virtual_food_cart_order.config.AppConfig;
import com.example.virtual_food_cart_order.dto.OrderDetailDto;
import com.example.virtual_food_cart_order.dto.OrderDto;
import com.example.virtual_food_cart_order.mapper.OrderMapper;
import com.example.virtual_food_cart_order.service.OrderDetailFoodService;
import com.example.virtual_food_cart_order.service.OrderDetailService;
import com.example.virtual_food_cart_order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private AppConfig appConfig;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private OrderDetailFoodService orderDetailFoodService;

    @GetMapping("/not-busy/{isSearch}/{orderId}/{pageNumber}")
    public ResponseEntity<List<OrderDto>> getNotBusyOrders(@PathVariable int isSearch,
                                                           @PathVariable Long orderId,
                                                           @PathVariable int pageNumber) {
        try {
            List<OrderDto> orderDtoList = new ArrayList<>();
            if (isSearch == 0) {
                orderDtoList = orderService.getNotBusyOrders(pageNumber);
            } else {
                OrderDto orderDto = orderService.findNotBusyOrderById(orderId);
                if (orderDto != null) {
                    orderDtoList.add(orderDto);
                }
            }

            if (orderDtoList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(orderDtoList, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/in-progress/{isSearch}/{orderId}/{pageNumber}")
    public ResponseEntity<List<OrderDto>> getInProgressOrder(@PathVariable int isSearch,
                                                           @PathVariable Long orderId,
                                                           @PathVariable int pageNumber) {
        try {
            List<OrderDto> orderDtoList = new ArrayList<>();
            if (isSearch == 0) {
                orderDtoList = orderService.getInProgressOrders(pageNumber);
            } else {
                OrderDto orderDto = orderService.findInProgressOrderById(orderId);
                if (orderDto != null) {
                    orderDtoList.add(orderDto);
                }
            }

            if (orderDtoList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(orderDtoList, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/delivered/{isSearch}/{orderId}/{pageNumber}")
    public ResponseEntity<List<OrderDto>> getDeliveredOrder(@PathVariable int isSearch,
                                                             @PathVariable Long orderId,
                                                             @PathVariable int pageNumber) {
        try {
            List<OrderDto> orderDtoList = new ArrayList<>();
            if (isSearch == 0) {
                orderDtoList = orderService.getDeliveredOrders(pageNumber);
            } else {
                OrderDto orderDto = orderService.findDeliveredOrderById(orderId);
                if (orderDto != null) {
                    orderDtoList.add(orderDto);
                }
            }

            if (orderDtoList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(orderDtoList, HttpStatus.OK);

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

    @PutMapping("/shipper/{orderId}")
    public ResponseEntity<Integer> receiveOrderByShipper(@PathVariable Long orderId) {
        try {
            int response = orderService.receiveOrderByShipper(orderId);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/shipper/finish/{orderId}")
    public ResponseEntity<Integer> finishOrder(@PathVariable Long orderId) {
        try {
            int response = orderService.finishOrder(orderId);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

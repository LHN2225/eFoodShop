package com.example.shipper.controller;

import java.util.List;

import com.example.shipper.service.OrderDetailFoodService;
import com.example.shipper.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.shipper.entity.Order;
import com.example.shipper.service.OrderService;

@Controller
@RequestMapping("/shipper/order")
public class OrderViewController {

    // Test for shipper id before authentication and authorization handling by security
    public Long shipper_id_test = 1L;
    
    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private OrderDetailFoodService orderDetailFoodService;

    @GetMapping("/in-progress")
    public String test8() {
        return "in-progress-order";
    }

    @GetMapping("/delivered")
    public String test9() {
        return "delivered-order";
    }

    @GetMapping("/fragment/not-busy")
    public String getNotBusyOrders(Model model) {
        List<Order> orders = orderService.getNotBusyOrders();
        model.addAttribute("orders", orders);
        return "fragment/not-busy-orders";
    }

    @GetMapping("/fragment/in-progress")
    public String getInProgressOrders(Model model) {
        List<Order> orders = orderService.getInProgressOrders(shipper_id_test);
        model.addAttribute("orders", orders);
        return "fragment/in-progress-orders-box";
    }

    @GetMapping("/fragment/delivered")
    public String getDeliveredOrders(Model model) {
        List<Order> orders = orderService.getDeliveredOrders(shipper_id_test);
        model.addAttribute("orders", orders);
        return "fragment/delivered-orders-box";
    }

}

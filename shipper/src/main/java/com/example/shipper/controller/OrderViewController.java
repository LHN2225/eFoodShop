package com.example.shipper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.shipper.entity.Order;
import com.example.shipper.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderViewController {
    
    @Autowired
    private OrderService orderService;

    @GetMapping("/not-busy")
    public String getNotBusyOrders(Model model) {
        List<Order> orders = orderService.getOrderThatNotBusy();
        model.addAttribute("orders", orders);
        return "fragment/not-busy-orders";
    }

}

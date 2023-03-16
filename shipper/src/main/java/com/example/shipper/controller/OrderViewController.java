package com.example.shipper.controller;

import java.util.List;

import com.example.shipper.repository.PageRepository;
import com.example.shipper.service.OrderDetailFoodService;
import com.example.shipper.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.shipper.entity.Order;
import com.example.shipper.service.OrderService;

@Controller
@RequestMapping("/shipper/order")
public class OrderViewController {

    // Page size
    public int pageSize = 5;

    // Test for shipper id before authentication and authorization handling by security
    public Long shipper_id_test = 1L;
    
    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private OrderDetailFoodService orderDetailFoodService;

    @Autowired
    private PageRepository pageRepository;

    @GetMapping("/in-progress")
    public String getInProgressOrdersPage(Model model) {
        model.addAttribute("pageNumber", pageRepository.findInProgressOrderTotalPageNumber(pageSize));
        return "in-progress-order";
    }

    @GetMapping("/delivered")
    public String getDeliveredOrdersPage(Model model) {
        model.addAttribute("pageNumber", pageRepository.findDeliveredOrderTotalPageNumber(pageSize));
        return "delivered-order";
    }

    @GetMapping("/fragment/not-busy/{pageNumber}")
    public String getNotBusyOrders(Model model, @PathVariable int pageNumber) {
        List<Order> orders = orderService.getNotBusyOrders(pageNumber);
        model.addAttribute("orders", orders);
        return "fragment/not-busy-orders";
    }

    @GetMapping("/fragment/in-progress/{pageNumber}")
    public String getInProgressOrders(Model model, @PathVariable int pageNumber) {
        List<Order> orders = orderService.getInProgressOrders(shipper_id_test, pageNumber);
        model.addAttribute("orders", orders);
        return "fragment/in-progress-orders-box";
    }

    @GetMapping("/fragment/delivered/{pageNumber}")
    public String getDeliveredOrders(Model model, @PathVariable int pageNumber) {
        List<Order> orders = orderService.getDeliveredOrders(shipper_id_test, pageNumber);
        model.addAttribute("orders", orders);
        return "fragment/delivered-orders-box";
    }

}

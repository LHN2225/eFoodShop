package com.example.shipper.controller;

import com.example.shipper.dto.OrderDetailDto;
import com.example.shipper.dto.OrderDetailFoodDto;
import com.example.shipper.entity.Order;
import com.example.shipper.repository.OrderRepository;
import com.example.shipper.repository.PageRepository;
import com.example.shipper.service.OrderDetailFoodService;
import com.example.shipper.service.OrderDetailService;
import com.example.shipper.service.OrderService;

import org.apache.tomcat.util.net.jsse.JSSEUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/")
public class TestController {

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDetailFoodService orderDetailFoodService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/1")
    public String index1() {
        return "profile";
    }

    @GetMapping("/2")
    public String index2() {
        return "sample-inner-page";
    }

    @GetMapping("/3")
    public String index3() {
        return "test";
    }

    @GetMapping("/4")
    public String index4() {
        return "home";
    }

    @GetMapping("/5")
    @ResponseBody
    public OrderDetailDto getAllDto() {
        return orderDetailService.getOrderDetailById(1L);
    }

    @GetMapping("/6")
    @ResponseBody
    public List<OrderDetailFoodDto> getAllFoods() {
        return orderDetailFoodService.getFoodsByOrderId(1L);
    }

    @GetMapping("/7")
    public String test7(Model model) {
        OrderDetailDto orderDetail = orderDetailService.getOrderDetailById(1L);
        model.addAttribute("orderDetail", orderDetail);
        model.addAttribute("foods", orderDetail.getFoods());
        return "order-detail";
    }

    @GetMapping("/8")
    public String test8() {
        return "in-progress-order";
    }

    @GetMapping("/9")
    public String test9() {
        return "delivered-order";
    }

    @GetMapping("/10/{password}")
    @ResponseBody
    public String test10(@PathVariable String password) {
        System.out.println(passwordEncoder.encode((password)));
        System.out.println(passwordEncoder.matches("123",
                "$2a$10$8z2WnT9SVaWLyYfwxbEEEOScnxcIFU1d7x86TE3Q8Rj.BJVXgUySy"));
        return "delivered-order";
    }

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PageRepository pageRepository;

    /*@GetMapping("/11/{pageNumber}")
    @ResponseBody
    public List<Order> test11(@PathVariable int pageNumber) {
        System.out.println(pageRepository.findNotBusyOrderTotalPageNumber(2));
        return orderRepository.findAll1(pageNumber, 2);
    }*/

    @PutMapping("/12/{orderId}")
    @ResponseBody
    public int test12(@PathVariable Long orderId) {
        return orderService.finishOrder(orderId);
    }
}

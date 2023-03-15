package com.example.shipper.controller;

import com.example.shipper.dto.OrderDetailDto;
import com.example.shipper.dto.OrderDetailFoodDto;
import com.example.shipper.service.OrderDetailFoodService;
import com.example.shipper.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/")
public class TestController {

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private OrderDetailFoodService orderDetailFoodService;

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
    
}

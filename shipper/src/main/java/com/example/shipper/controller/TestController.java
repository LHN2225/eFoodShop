package com.example.shipper.controller;

import com.example.shipper.dto.OrderDetailDto;
import com.example.shipper.dto.UserLoginDto;
import com.example.shipper.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/")
public class TestController {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

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
    public List<OrderDetailDto> getAllDto() {
        return orderDetailRepository.findByOrderId(1L);
    }

    @GetMapping("/6")
    @ResponseBody
    public List<UserLoginDto> getAllDto1() {
        return orderDetailRepository.test();
    }
    
}

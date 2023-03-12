package com.example.shipper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TestController {

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
    
}

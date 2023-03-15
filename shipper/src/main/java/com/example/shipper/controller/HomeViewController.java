package com.example.shipper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shipper/home")
public class HomeViewController {

    @GetMapping("")
    public String home() {
        return "home";
    }
}

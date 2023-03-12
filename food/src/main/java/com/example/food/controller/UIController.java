package com.example.food.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UIController {

    @GetMapping("/ui")
    public String UI() {
        return "view-all-food";
    }
}

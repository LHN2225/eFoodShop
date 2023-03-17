package com.example.managerinfo.controller;

import com.example.managerinfo.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FoodController {

    @Autowired
    private FoodService foodService;

    @GetMapping("get-all-food")
    public String customerGetAllFood(Model model) {
        model.addAttribute("foods", foodService.findAll());
        return "CustomerMenu";
    }
}

package com.example.food.controller;

import com.example.food.dto.FoodDetailDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UIController {

    @GetMapping("/ui")
    public String UI(final Model model) {
        model.addAttribute("Model", new FoodDetailDto(
                2L,
                "Pho haha",
                "Some thing describe the food",
                "1678613999670.jpg",
                35000F
        ));
        return "view-food-detail";
    }
}

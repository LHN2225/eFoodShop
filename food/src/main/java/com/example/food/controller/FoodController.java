package com.example.food.controller;

import com.example.food.dto.CreateFoodDto;
import com.example.food.entity.Food;
import com.example.food.service.FoodService;
import com.example.food.service.StorageService;
import com.example.food.viewmodel.FoodListViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("/food")
public class FoodController {
    @Autowired
    FoodService foodService;
    @Autowired
    StorageService storageService;

    @GetMapping("view-food")
    @ResponseBody
    public FoodListViewModel viewAllFoodPage(@RequestParam(value = "page", required = false , defaultValue = "1") int page_number,
                                             final Model model) {
        FoodListViewModel viewModel = foodService.viewAllFood(page_number);
        model.addAttribute("Model", viewModel);

        return viewModel;
//        return "ViewAllFood";
    }

    @PostMapping(value = "save-food", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    public String viewAllFoodPage(@ModelAttribute @Valid CreateFoodDto createFoodDto,
                                  HttpServletRequest request) throws IOException {
        String referer = request.getHeader("Referer");

        String imageName = storageService.saveImage(createFoodDto.getImage(), "/image-food");
        if (imageName.isEmpty()) return "redirect:"+referer;

        foodService.saveFood(new Food(
                createFoodDto.getName(),
                createFoodDto.getDescription(),
                imageName,
                createFoodDto.getPrice()
        ));

        return "redirect:"+referer;
    }

    @DeleteMapping("remove-food")
    @ResponseBody
    public String viewAllFoodPage(@RequestParam(value = "id") long id,
                                  HttpServletRequest request) throws IOException {
        foodService.deleteFood(id);

        String referer = request.getHeader("Referer");
        return "redirect:"+referer;
    }
}

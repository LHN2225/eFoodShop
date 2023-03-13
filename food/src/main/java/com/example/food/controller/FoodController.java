package com.example.food.controller;

import com.example.food.dto.CreateFoodDto;
import com.example.food.dto.FoodDetailDto;
import com.example.food.dto.UpdateFoodDto;
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
    public String viewAllFoodPage(@RequestParam(value = "page", required = false , defaultValue = "1") int page_number,
                                             final Model model) {
        FoodListViewModel viewModel = foodService.viewAllFood(page_number);
        model.addAttribute("Model", viewModel);

//        return viewModel;
        return "view-all-food";
    }
    @GetMapping("create-food")
    public String viewAllFoodPage() {
        return "create-food";
    }


    @PostMapping(value = "save-food", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String saveFood(@ModelAttribute @Valid CreateFoodDto createFoodDto) {
        try {
            String imageName = storageService.saveImage(createFoodDto.getImage(), "/image-food");
            if (imageName.isEmpty()) return "bad-request-message";

            foodService.saveFood(new Food(
                    createFoodDto.getName(),
                    createFoodDto.getDescription(),
                    imageName,
                    createFoodDto.getPrice()
            ));
        }
        catch (Exception e) {
            System.out.println(e);
            return "bad-request-message";
        }

        return "success-message";
    }

    @GetMapping("remove-food")
    public String deleteFood(@RequestParam(value = "id") long id) {
        foodService.deleteFood(id);

        return "success-message";
    }

    @GetMapping("view-food-detail")
    @ResponseBody
    public FoodDetailDto viewFoodDetailPage(@RequestParam(value = "id") long id,
                                         final Model model,
                                         HttpServletRequest request) {
        FoodDetailDto foodDetailDto = foodService.viewFoodDetail(id);
        if (foodDetailDto == null) {
            String referer = request.getHeader("Referer");
            return new FoodDetailDto();
//            return "redirect:"+referer;
        }
        model.addAttribute("Model", foodDetailDto);

        return foodDetailDto;
//        return "ViewAllFood";
    }

    @PostMapping(value = "update-food", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String updateFood(@ModelAttribute @Valid UpdateFoodDto updateFoodDto) {

        try {
            String imageName;
            if (updateFoodDto.getIsImageChange()) {
                imageName = storageService.saveImage(updateFoodDto.getImage(), "/image-food");
                if (imageName.isEmpty()) return "bad-request-message";

                foodService.updateFoodWithNewImage(new Food(
                        updateFoodDto.getId(),
                        updateFoodDto.getName(),
                        updateFoodDto.getDescription(),
                        imageName,
                        updateFoodDto.getPrice()
                ));
            }
            else {
                foodService.updateFoodWithoutImage(new Food(
                        updateFoodDto.getId(),
                        updateFoodDto.getName(),
                        updateFoodDto.getDescription(),
                        updateFoodDto.getPrice()
                ));
            }

        }
        catch (Exception e) {
            System.out.println(e);
            return "bad-request-message";
        }

        return "success-message";
    }
}

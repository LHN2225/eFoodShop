package com.example.food.controller;

import com.example.food.dto.CreateFoodDto;
import com.example.food.dto.FoodDetailDto;
import com.example.food.dto.UpdateFoodDto;
import com.example.food.entity.Food;
import com.example.food.helper.Helper;
import com.example.food.service.FoodService;
import com.example.food.viewmodel.FoodListViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

@Controller
public class FoodController {
    @Autowired
    FoodService foodService;
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("view-food")
    public String viewAllFoodPage(@RequestParam(value = "page", required = false , defaultValue = "1") int page_number,
                                             final Model model) {
        FoodListViewModel viewModel = foodService.viewAllFood(page_number);
        model.addAttribute("Model", viewModel);

        return "view-all-food";
    }
    @GetMapping("create-food")
    public String viewAllFoodPage() {
        return "create-food";
    }


    @PostMapping(value = "save-food", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String saveFood(@ModelAttribute @Valid CreateFoodDto createFoodDto) {
        try {
            Helper helper = new Helper();
            String imageName = helper.uploadImage(createFoodDto.getImage(), restTemplate);
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
    public String viewFoodDetailPage(@RequestParam(value = "id") long id,
                                         final Model model) {
        FoodDetailDto foodDetailDto = foodService.viewFoodDetail(id);
        if (foodDetailDto == null) {
            return "bad-request-message";
        }
        model.addAttribute("Model", foodDetailDto);

        return "view-food-detail";
    }

    @PostMapping(value = "update-food", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String updateFood(@ModelAttribute @Valid UpdateFoodDto updateFoodDto) {

        try {
            String imageName;
            if (updateFoodDto.getIsImageChange()) {
                Helper helper = new Helper();
                imageName = helper.uploadImage(updateFoodDto.getImage(), restTemplate);
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

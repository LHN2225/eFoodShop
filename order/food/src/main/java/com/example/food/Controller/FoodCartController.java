package com.example.food.Controller;

import com.example.food.DTO.FoodCartDTO;
import com.example.food.DTO.FoodCartDetailDTO;
import com.example.food.Service.FoodCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/foodCart")
public class FoodCartController {
    @Autowired
    private FoodCartService foodCartService;

    @PutMapping("/{foodCartId}")
    public ResponseEntity<?> updateFoodCart(@PathVariable Long foodCartId, @RequestBody FoodCartDetailDTO foodCartDetailDTO) {
        try {
            foodCartDetailDTO.setFoodCartId(foodCartId);
            FoodCartDetailDTO updatedFoodCart = foodCartService.updateFoodCart(foodCartDetailDTO);
            return ResponseEntity.ok(updatedFoodCart);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred.");
        }
    }

    @GetMapping("/orders")
    public ResponseEntity<List<FoodCartDTO>> findOrdersByCustomerId(@RequestParam Long customerId) {
        List<FoodCartDTO> foodCartDTOs = foodCartService.findFoodCartDTOByCustomerId(customerId);
        return ResponseEntity.ok(foodCartDTOs);
    }
}

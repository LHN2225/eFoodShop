package com.example.food.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class CreateFoodDto {
    @NotEmpty
    String name;
    String description;
    @NotNull
    MultipartFile image;
    @NotNull
    Float price;
}

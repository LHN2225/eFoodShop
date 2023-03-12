package com.example.food.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class UpdateFoodDto {
    @NotNull
    Long id;
    @NotEmpty
    String name;
    String description;
    @NotNull
    MultipartFile image;
    @NotNull
    Float price;
    @NotNull
    @Value("false")
    Boolean isImageChange;
}


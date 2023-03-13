package com.example.cart.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodDto {
    private Long id;

    private String name;

    private Long price;

    private String description;

    private String imageLink;

    private Boolean isDeleted;
}

package com.example.managerinfo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FoodDto {
    private Long id;
    private String name;
    private float price;
    private String description;
    private String imageLink;
    private boolean isDeleted;
}

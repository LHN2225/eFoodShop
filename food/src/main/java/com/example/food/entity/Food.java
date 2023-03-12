package com.example.food.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "food")
@Data
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String description;
    String imageUrl;
    Float price;
    Boolean isDeleted;

    public Food(String name, String description, String imageUrl, Float price) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.price = price;
    }
}

package com.example.food.entity;

import lombok.AllArgsConstructor;
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
    String imageLink;
    Float price;
    Boolean isDeleted;

    public Food(String name, String description, String imageLink, Float price) {
        this.name = name;
        this.description = description;
        this.imageLink = imageLink;
        this.price = price;
    }

    public Food(Long id, String name, String description, String imageLink, Float price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageLink = imageLink;
        this.price = price;
    }

    public Food(Long id, String name, String description, Float price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }
}

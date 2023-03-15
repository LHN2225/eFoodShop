package com.example.food.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "FOOD")
@Data
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FOOD_ID")
    private Long foodId;
    @Column(name = "FOOD_NAME")
    private String foodName;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "IMAGE_URL")
    private String imageUrl;
    @Column(name = "PRICE")
    private Float price;
    @Column(name = "IS_DELETED")
    private String isDeleted;
}

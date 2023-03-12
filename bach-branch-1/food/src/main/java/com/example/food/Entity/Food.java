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
    Long foodId;
    @Column(name = "FOOD_NAME")
    String foodName;
    @Column(name = "DESCRIPTION")
    String description;
    @Column(name = "IMAGE_URL")
    String imageUrl;
    @Column(name = "PRICE")
    Float price;
    @Column(name = "IS_DELETED")
    Boolean isDeleted;
}

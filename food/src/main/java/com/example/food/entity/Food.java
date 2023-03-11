package com.example.food.entity;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name = "food")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String description;
    String imageUrl;
    Float price;
    Boolean isDeleted;
}

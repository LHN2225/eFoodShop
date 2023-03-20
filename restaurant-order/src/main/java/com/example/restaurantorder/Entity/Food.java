package com.example.restaurantorder.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "food")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private float price;
    @Column(name = "description")
    private String description;
    @Column(name = "image_link")
    private String imageLink;
    @Column(name = "is_deleted")
    private boolean isDeleted;
}


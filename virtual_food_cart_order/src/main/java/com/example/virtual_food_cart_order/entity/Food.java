package com.example.virtual_food_cart_order.entity;

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

    private String name;
    private float price;
    private String description;

    @Column(name = "image_link")
    private String imageLink;

    @Column(name = "is_deleted")
    private boolean isDeleted;
}

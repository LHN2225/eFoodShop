package com.example.shipper.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "food_cart")
public class FoodCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "food_id")
    private Long foodId;

    @Column(name = "cart_id")
    private Long cartId;

    @Column(name = "food_quantity")
    private Long foodQuantity;

    @Column(name = "fixed_price")
    private float fixedPrice;

    @Column(name = "is_deleted")
    private boolean isDeleted;
}
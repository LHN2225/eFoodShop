package com.example.virtual_food_cart_order.entity;

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
}

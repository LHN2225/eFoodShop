package com.example.food.Entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "FOOD_CART")
@Data
public class FoodCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FOOD_CART_ID")
    private Long foodCartId;

    @Column(name = "FOOD_ID")
    private Long foodId;

    @Column(name = "CART_ID")
    private Long cartId;

    @Column(name = "FOOD_QUANTITY")
    private Float foodQuantity;

    @Column(name = "FIXED_PRICE")
    private Float fixedPrice;
}

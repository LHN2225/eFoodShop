package com.example.cart.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="food_cart")
@NoArgsConstructor
@AllArgsConstructor
public class FoodCart {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @Column(name="food_id")
    private Long foodId;

    @Column(name="cart_id")
    private Long cartId;

    @Column(name="food_quantity")
    private Long foodQuantity;

    @Column(name="fixed_price")
    private float fixedPrice;
}

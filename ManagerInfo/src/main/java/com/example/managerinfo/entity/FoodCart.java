package com.example.managerinfo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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

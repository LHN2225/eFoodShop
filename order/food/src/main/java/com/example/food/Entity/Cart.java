package com.example.food.Entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "CART")
@Data
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CART_ID")
    Long cartId;
    @Column(name = "CUSTOMER_ID")
    Long customerId;
}

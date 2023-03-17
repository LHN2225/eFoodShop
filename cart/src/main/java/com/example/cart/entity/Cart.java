package com.example.cart.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="cart")
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @Column(name="customer_id")
    private Long customerId;

    @Column(name = "is_deleted")
    private boolean isDeleted;
}

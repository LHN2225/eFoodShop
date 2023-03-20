package com.example.restaurantorder.Entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "customer_id")
    private Long customerId;
    @Column(name = "is_deleted")
    private Boolean isDeleted;
}


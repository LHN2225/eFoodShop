package com.example.restaurantorder.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "restaurant_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "cart_id")
    private Long cartId;
    @Column(name = "address")
    private String address;
    @Column(name = "shipper_id")
    private Long shipperId;
    @Column(name = "shipping_status")
    private String shippingStatus;
    @Column(name = "is_deleted")
    private Boolean isDeleted;
}


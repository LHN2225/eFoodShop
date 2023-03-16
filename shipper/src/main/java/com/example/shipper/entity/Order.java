package com.example.shipper.entity;

import lombok.Data;

import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@Data
@Table(name = "order_1")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cart_id")
    private Long cartId;

    @Column(name = "created_date")
    private Timestamp createdDate;

    @Column(name = "address")
    private String address;

    @Column(name = "shipper_id")
    private Long shipperId;

    @Column(name = "shipping_status")
    private String shippingStatus;

    @Column(name = "is_deleted")
    private boolean isDeleted;
}

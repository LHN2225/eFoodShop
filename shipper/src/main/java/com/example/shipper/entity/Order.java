package com.example.shipper.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "ORDER_1")
public class Order {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "cart_id")
    private Long cartId;

    @Column(name = "shipper_id")
    private Long shipperId;

    @Column(name = "shipping_status")
    private String shippingStatus;
}

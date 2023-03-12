package com.example.food.Entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "ORDER")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    Long orderId;
    @Column(name = "CART_ID")
    Long cartId;
    @Column(name = "SHIPPER_ID")
    Long shipperId;
    @Column(name = "SHIPPING_STATUS")
    String shippingStatus;
}

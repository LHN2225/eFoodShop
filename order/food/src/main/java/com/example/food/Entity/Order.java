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
    private Long orderId;
    @Column(name = "CART_ID")
    private Long cartId;
    @Column(name = "SHIPPER_ID")
    private Long shipperId;
    @Column(name = "SHIPPING_STATUS")
    private String shippingStatus;
    @Column(name = "TOTAL")
    private Float total;
    @ManyToOne
    @JoinColumn(name = "CART_ID", insertable = false, updatable = false)
    private Cart cart;

    public void setCart(Cart cart) {
        this.cart = cart;
        this.cartId = cart.getCartId();
    }
}

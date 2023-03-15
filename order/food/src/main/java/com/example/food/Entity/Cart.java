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
    private Long cartId;
    @Column(name = "CUSTOMER_ID")
    private Long customerId;
    @Column(name = "IS_DELETED")
    private String is_deleted;
    public String getIsDeleted() {
        return is_deleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.is_deleted = isDeleted;
    }
}

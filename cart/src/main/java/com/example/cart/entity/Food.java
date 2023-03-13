package com.example.cart.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="food")
@NoArgsConstructor
@AllArgsConstructor
public class Food {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="price")
    private Long price;

    @Column(name="description")
    private String description;

    @Column(name="image_link")
    private String imageLink;

    @Column(name="is_deleted")
    private Boolean isDeleted;

}

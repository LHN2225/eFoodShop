package com.example.managerinfo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "food")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private float price;
    private String description;

    @Column(name = "image_link")
    private String imageLink;

    @Column(name = "is_deleted")
    private boolean isDeleted;
}

package com.example.userservice.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 45)
    private String name;

    public Role(Long id) {
        this.id = id;
    }

    public Role(String name) {
        this.name = name;
    }
}
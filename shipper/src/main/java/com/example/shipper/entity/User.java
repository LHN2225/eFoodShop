package com.example.shipper.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "USER_1")
public class User {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "phone")
    private String phone;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}

package com.example.userservice.entity;

import javax.persistence.*;

import lombok.*;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "restaurant_user")
public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;

        @Column(name = "email")
        private String email;

        @Column(name = "password")
        private String password;

        @Column(name = "fullname")
        private String fullname;

        @Column(name = "phone")
        private String phone;

        @Column(name = "role_id")
        private Long roleId;
}

package com.example.cart.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="role")
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @Column(name="id")
    private Long id;

    @Column(name="role_name")
    private String roleName;
}

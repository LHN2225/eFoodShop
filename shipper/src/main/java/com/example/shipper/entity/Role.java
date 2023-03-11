package com.example.shipper.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "ROLE")
public class Role {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "role_name")
    private String roleName;
}

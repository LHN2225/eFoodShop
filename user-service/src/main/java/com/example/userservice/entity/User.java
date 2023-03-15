package com.example.userservice.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
@Setter
@Getter
@ToString
@Entity
@Table(name = "users")
public class User {


        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @Column(nullable = false, unique = true, length = 45)
        private String email;

        @Column(nullable = false, length = 64)
        private String password;

        @Column(name = "full_name", nullable = false, length = 20)
        private String fullName;

        @ManyToMany(fetch = FetchType.EAGER)
        @JoinTable(
                name = "users_roles",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "role_id")
        )
        private Set<Role> roles = new HashSet<>();


        public void addRole(Role role) {
        this.roles.add(role);}

}

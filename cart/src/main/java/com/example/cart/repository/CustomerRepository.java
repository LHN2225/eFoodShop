package com.example.cart.repository;

import com.example.cart.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<User, Long> {
    User findByIdAndRoleId(Long userId, Long roleId);
    User findByEmail(String email);
}

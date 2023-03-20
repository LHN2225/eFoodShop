package com.example.restaurantorder.Repository;

import com.example.restaurantorder.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByCartId(Long cartId);
    Optional<Order> findById(Long id);
}
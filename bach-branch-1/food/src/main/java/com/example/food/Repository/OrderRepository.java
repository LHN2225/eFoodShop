package com.example.food.Repository;

import com.example.food.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByCartId(Long cartId);
    List<Order> findByCustomerId(Long customerId);
}
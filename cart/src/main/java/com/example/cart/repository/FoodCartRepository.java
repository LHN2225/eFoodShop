package com.example.cart.repository;

import com.example.cart.entity.FoodCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodCartRepository extends JpaRepository<FoodCart, Long> {
    FoodCart findByFoodIdAndCartId(Long foodId, Long cartId);
    List<FoodCart> findByCartId(Long cartId);
}

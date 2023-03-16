package com.example.cart.repository;

import com.example.cart.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FoodReposiroty extends JpaRepository<Food, Long> {
    Optional<Food> findById(Long id);
}

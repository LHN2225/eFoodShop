package com.example.cart.repository;

import com.example.cart.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodReposiroty extends JpaRepository<Food, Long> {
}

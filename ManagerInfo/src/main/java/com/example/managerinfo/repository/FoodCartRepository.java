package com.example.managerinfo.repository;

import com.example.managerinfo.entity.FoodCart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodCartRepository extends CrudRepository<FoodCart, Long> {
    FoodCart findByFoodIdAndCartId(Long foodId, Long cartId);
}

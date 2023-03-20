package com.example.restaurantorder.Repository;

import com.example.restaurantorder.DTO.CartInfoDTO;
import com.example.restaurantorder.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    @Query("SELECT new com.example.restaurantorder.DTO.CartInfoDTO(f.name, fc.foodQuantity, fc.fixedPrice) " +
            "FROM Cart c " +
            "JOIN FoodCart fc ON c.id = fc.cartId " +
            "JOIN Food f ON f.id = fc.foodId " +
            "WHERE c.id = :id")
    List<CartInfoDTO> findCartInfoByCartId(@Param("id") Long id);
}
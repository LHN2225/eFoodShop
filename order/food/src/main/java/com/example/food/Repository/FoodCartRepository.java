package com.example.food.Repository;

import com.example.food.DTO.OrderFoodDTO;
import com.example.food.Entity.FoodCart;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodCartRepository extends JpaRepository<FoodCart, Long> {
    List<FoodCart> findByCartId(Long cartId);
    @Query("SELECT SUM(f.foodQuantity * f.fixedPrice) FROM FoodCart f WHERE f.cartId = :cartId")
    Float sumTotalByCartId(@Param("cartId") Long cartId);

    @Query("SELECT fc.food.foodId, fc.food.foodName, fc.foodQuantity, fc.fixedPrice, (fc.foodQuantity * fc.fixedPrice) AS sum " +
            "FROM FoodCart fc " +
            "WHERE fc.cart.customer.userId = :customerId " +
            "AND fc.cart.order.orderId = :orderId")
    List<OrderFoodDTO> getOrderFoodsByCustomerIdAndOrderId(Long customerId, Long orderId);
}

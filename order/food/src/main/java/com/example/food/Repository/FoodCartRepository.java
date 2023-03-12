package com.example.food.Repository;

import com.example.food.DTO.FoodCartDTO;
import com.example.food.Entity.FoodCart;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FoodCartRepository extends JpaRepository<FoodCart, Long>, JpaSpecificationExecutor<FoodCart> {
    List<FoodCart> findByCartId(Long cartId);

    @Modifying
    @Query("UPDATE FoodCart SET foodQuantity = :foodQuantity, fixedPrice = :fixedPrice WHERE foodCartId = :foodCartId")
    void updateFoodCart(@Param("foodCartId") Long foodCartId, @Param("foodQuantity") Float foodQuantity, @Param("fixedPrice") Float fixedPrice);

    @Query("SELECT NEW com.example.demo.dto.FoodCartDTO(fc.foodCartId, f.foodName, fc.foodQuantity, fc.fixedPrice, fc.foodQuantity * fc.fixedPrice, o.shippingStatus) "
            + "FROM FoodCart fc "
            + "JOIN fc.food f "
            + "JOIN fc.cart c "
            + "JOIN c.customer cu "
            + "JOIN c.order o "
            + "WHERE cu.customerId = :customerId")
    List<FoodCartDTO> findFoodCartDTOByCustomerId(Long customerId);
}

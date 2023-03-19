package com.example.virtual_food_cart_order.repository;

import com.example.virtual_food_cart_order.dto.OrderDetailFoodDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDetailFoodRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<OrderDetailFoodDto> findByOrderId(Long orderId) {
        String query = "SELECT\n" +
                "\tFOOD.NAME,\n" +
                "\tFOOD_CART.FOOD_QUANTITY QUANTITY,\n" +
                "\tFOOD_CART.FIXED_PRICE * FOOD_CART.FOOD_QUANTITY COST\n" +
                "FROM RESTAURANT_ORDER\n" +
                "\tJOIN CART ON CART.ID = RESTAURANT_ORDER.CART_ID\n" +
                "\tJOIN FOOD_CART ON FOOD_CART.CART_ID = CART.ID\n" +
                "\tJOIN FOOD ON FOOD.ID = FOOD_CART.FOOD_ID\n" +
                "WHERE\n" +
                "\tRESTAURANT_ORDER.ID = " + orderId + "\n" +
                "\tAND FOOD.IS_DELETED = 0";

        return jdbcTemplate
                .query(query,
                        (rs, rowNum) ->
                                new OrderDetailFoodDto(
                                        rs.getString("name"),
                                        rs.getInt("quantity"),
                                        rs.getFloat("cost")
                                )
                );
    }
}

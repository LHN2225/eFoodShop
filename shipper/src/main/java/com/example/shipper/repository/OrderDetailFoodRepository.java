package com.example.shipper.repository;

import com.example.shipper.dto.OrderDetailDto;
import com.example.shipper.dto.OrderDetailFoodDto;
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
                "FROM ORDER_1\n" +
                "\tJOIN CART ON CART.ID = ORDER_1.CART_ID\n" +
                "\tJOIN FOOD_CART ON FOOD_CART.CART_ID = CART.ID\n" +
                "\tJOIN FOOD ON FOOD.ID = FOOD_CART.FOOD_ID\n" +
                "WHERE\n" +
                "\tORDER_1.ID = " + orderId + "\n" +
                "\tAND FOOD.IS_DELETED = 0\n" +
                "\tAND CART.IS_DELETED = 0";

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

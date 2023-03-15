package com.example.shipper.repository;

import com.example.shipper.dto.OrderDetailDto;
import com.example.shipper.dto.UserLoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class OrderDetailRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public OrderDetailDto findByOrderId(Long orderId) {
        String query = "SELECT\n" +
                "\tORDER_1.ID ORDER_ID, ORDER_1.CREATED_DATE, ORDER_1.ADDRESS,\n" +
                "\tUSER_1.FULLNAME CUSTOMER_FULLNAME,\n" +
                "\tSHIPPER.FULLNAME SHIPPER_FULLNAME\n" +
                "FROM ORDER_1\n" +
                "\tJOIN CART ON CART.ID = ORDER_1.CART_ID\n" +
                "\tJOIN USER_1 ON USER_1.ID = CART.CUSTOMER_ID\n" +
                "\tJOIN USER_1 SHIPPER ON SHIPPER.ID = ORDER_1.SHIPPER_ID \n" +
                "WHERE\n" +
                "\tORDER_1.ID = " + orderId + "\n" +
                "\tAND CART.IS_DELETED = 0";

        return jdbcTemplate
                .queryForObject(query,
                        (rs, rowNum) ->
                                new OrderDetailDto(
                                        rs.getLong("order_id"),
                                        rs.getTimestamp("created_date"),
                                        rs.getString("address"),
                                        rs.getString("customer_fullname"),
                                        rs.getString("shipper_fullname")
                                )
                );
    }

}


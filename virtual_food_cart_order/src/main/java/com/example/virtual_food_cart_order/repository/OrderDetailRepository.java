package com.example.virtual_food_cart_order.repository;

import com.example.virtual_food_cart_order.dto.OrderDetailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDetailRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public OrderDetailDto findByOrderId(Long orderId) {
        String query = "SELECT\n" +
                "\tRESTAURANT_ORDER.ID ORDER_ID, RESTAURANT_ORDER.ADDRESS,\n" +
                "\tRESTAURANT_USER.FULLNAME CUSTOMER_FULLNAME,\n" +
                "\tRESTAURANT_USER.PHONE CUSTOMER_PHONE,\n" +
                "\tSHIPPER.FULLNAME SHIPPER_FULLNAME\n" +
                "FROM RESTAURANT_ORDER\n" +
                "\tJOIN CART ON CART.ID = RESTAURANT_ORDER.CART_ID\n" +
                "\tJOIN RESTAURANT_USER ON RESTAURANT_USER.ID = CART.CUSTOMER_ID\n" +
                "\tJOIN RESTAURANT_USER SHIPPER ON SHIPPER.ID = RESTAURANT_ORDER.SHIPPER_ID \n" +
                "WHERE\n" +
                "\tRESTAURANT_ORDER.ID = " + orderId + "\n" +
                "\tAND RESTAURANT_ORDER.IS_DELETED = 0\n" +
                "\n" +
                "UNION\n" +
                "\n" +
                "SELECT\n" +
                "\tRESTAURANT_ORDER.ID ORDER_ID, RESTAURANT_ORDER.ADDRESS,\n" +
                "\tRESTAURANT_USER.FULLNAME CUSTOMER_FULLNAME,\n" +
                "\tRESTAURANT_USER.PHONE CUSTOMER_PHONE,\n" +
                "\t' ' SHIPPER_FULLNAME\n" +
                "FROM RESTAURANT_ORDER\n" +
                "\tJOIN CART ON CART.ID = RESTAURANT_ORDER.CART_ID\n" +
                "\tJOIN RESTAURANT_USER ON RESTAURANT_USER.ID = CART.CUSTOMER_ID\n" +
                "WHERE\n" +
                "\tRESTAURANT_ORDER.ID = " + orderId + "\n" +
                "\tAND RESTAURANT_ORDER.SHIPPER_ID IS NULL\n" +
                "\tAND RESTAURANT_ORDER.IS_DELETED = 0";
        
                try {
                        return jdbcTemplate
                        .queryForObject(query,
                                (rs, rowNum) ->
                                        new OrderDetailDto(
                                                rs.getLong("order_id"),
                                                rs.getString("address"),
                                                rs.getString("customer_fullname"),
                                                rs.getString("customer_phone"),
                                                rs.getString("shipper_fullname")
                                        )
                        );
                } catch (Exception e) {
                        return null;
                }
    }

}


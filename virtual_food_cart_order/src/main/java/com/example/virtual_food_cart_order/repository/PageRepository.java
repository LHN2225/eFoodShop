package com.example.virtual_food_cart_order.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PageRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int findNotBusyOrderTotalPageNumber(String shippingStatus, int pageSize) {
        String template = "SELECT CEIL(COUNT(1)/%d) FROM RESTAURANT_ORDER WHERE SHIPPER_ID IS NULL AND RESTAURANT_ORDER.IS_DELETED = 0 AND SHIPPING_STATUS = \'%s\'";
        String query = String.format(template, pageSize, shippingStatus);

        return jdbcTemplate
                .queryForObject(query, Integer.class);
    }

    public int findInProgressOrderTotalPageNumber(Long shipperId, String shippingStatus, int pageSize) {
        String template = "SELECT CEIL(COUNT(1)/%d) FROM RESTAURANT_ORDER WHERE SHIPPER_ID = %s AND RESTAURANT_ORDER.IS_DELETED = 0 AND SHIPPING_STATUS = \'%s\'";
        String query = String.format(template, pageSize, String.valueOf(shipperId), shippingStatus);

        return jdbcTemplate
                .queryForObject(query, Integer.class);
    }

    public int findDeliveredOrderTotalPageNumber(Long shipperId, String shippingStatus, int pageSize) {
        String template = "SELECT CEIL(COUNT(1)/%d) FROM RESTAURANT_ORDER WHERE SHIPPER_ID = %s AND RESTAURANT_ORDER.IS_DELETED = 0 AND SHIPPING_STATUS = \'%s\'";
        String query = String.format(template, pageSize, String.valueOf(shipperId), shippingStatus);

        return jdbcTemplate
                .queryForObject(query, Integer.class);
    }
}

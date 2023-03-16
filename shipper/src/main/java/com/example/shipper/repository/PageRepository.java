package com.example.shipper.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PageRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int findNotBusyOrderTotalPageNumber(String shippingStatus, int pageSize) {
        String template = "SELECT CEIL(COUNT(1)/%d) FROM ORDER_1 WHERE SHIPPER_ID IS NULL AND SHIPPING_STATUS = \'%s\'";
        String query = String.format(template, pageSize, shippingStatus);
        //String query = "SELECT CEIL(COUNT(1)/" + pageSize + ") FROM ORDER_1 WHERE SHIPPER_ID IS NULL AND SHIPPING_STATUS = IN_PROGRESS";

        return jdbcTemplate
                .queryForObject(query, Integer.class);
    }

    public int findInProgressOrderTotalPageNumber(Long shipperId, String shippingStatus, int pageSize) {
        String query = "SELECT CEIL(COUNT(1)/" + pageSize + ") FROM ORDER_1";

        return jdbcTemplate
                .queryForObject(query, Integer.class);
    }

    public int findDeliveredOrderTotalPageNumber(Long shipperId, String shippingStatus, int pageSize) {
        String query = "SELECT CEIL(COUNT(1)/" + pageSize + ") FROM ORDER_1";

        return jdbcTemplate
                .queryForObject(query, Integer.class);
    }
}

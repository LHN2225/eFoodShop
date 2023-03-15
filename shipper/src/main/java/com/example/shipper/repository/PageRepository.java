package com.example.shipper.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PageRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int findOrderTotalPageNumber(int pageSize) {
        String query = "SELECT CEIL(COUNT(1)/" + pageSize + ") FROM ORDER_1";

        return jdbcTemplate
                .queryForObject(query, Integer.class);
    }
}

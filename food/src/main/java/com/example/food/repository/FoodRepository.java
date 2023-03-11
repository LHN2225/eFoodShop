package com.example.food.repository;

import com.example.food.convention.PageConvention;
import com.example.food.dto.FoodRecordDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FoodRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public int getTotalPageAllFood() {
        Integer result = jdbcTemplate
                .queryForObject("select ceil(count(*)/ "+ PageConvention.PAGE_SIZE +")"
                                + " from food"
                                + " where is_deleted = 0",
                        Integer.class
                );
        return result == null ? 0 : result;
    }

    public List<FoodRecordDto> getAllFood(int pageNumber) {
        return jdbcTemplate
                .query("select id, name, description, image_url, price"
                                + " from food"
                                + " where is_deleted = 0"
                                + " offset ("+ PageConvention.PAGE_SIZE +"*" + (pageNumber - 1) +") rows fetch next "+ PageConvention.PAGE_SIZE +" rows only",
                        (rs, rowNum) ->
                                new FoodRecordDto(
                                        rs.getLong("id"),
                                        rs.getString("name"),
                                        rs.getString("image_url"),
                                        rs.getFloat("price")
                                )
                );
    }
}

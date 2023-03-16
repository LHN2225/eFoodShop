package com.example.food.repository;

import com.example.food.convention.PageConvention;
import com.example.food.dto.FoodDetailDto;
import com.example.food.dto.FoodRecordDto;
import com.example.food.entity.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
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
                .query("select id, name, description, image_link, price"
                                + " from food"
                                + " where is_deleted = 0"
                                + " offset ("+ PageConvention.PAGE_SIZE +"*" + (pageNumber - 1) +") rows fetch next "+ PageConvention.PAGE_SIZE +" rows only",
                        (rs, rowNum) ->
                                new FoodRecordDto(
                                        rs.getLong("id"),
                                        rs.getString("name"),
                                        rs.getString("image_link"),
                                        rs.getFloat("price")
                                )
                );
    }

    public int saveFood(Food food) {
        return jdbcTemplate.update("insert into food (name, description, image_link, price, is_deleted) " +
                "values (?, ?, ?, ?, 0)",
                food.getName(),
                food.getDescription(),
                food.getImageLink(),
                food.getPrice()
        );

    }

    public int deleteFood(long id) {
        return jdbcTemplate.update("update food set is_deleted = 1 where id = " + id + " and is_deleted = 0");
    }

    public FoodDetailDto viewFoodDetail(long id) throws NoResultException {
        FoodDetailDto result = (FoodDetailDto) jdbcTemplate
                .queryForObject("select id, name, description, image_link, price"
                                + " from food"
                                + " where id = " + id + " and is_deleted = 0",
                        (rs, rowNum) ->
                                new FoodDetailDto(
                                        rs.getLong("id"),
                                        rs.getString("name"),
                                        rs.getString("description"),
                                        rs.getString("image_link"),
                                        rs.getFloat("price")
                                )
                );

        return result;
    }

    public int updateFoodWithoutImage(Food food) {
        return jdbcTemplate.update("UPDATE food"
                +" SET name = "+ "'" + food.getName() + "'"
                +", description = '"+ food.getDescription() + "'"
                +", price = "+ food.getPrice()
                +" WHERE id = "+ food.getId()
                +" and is_deleted = 0"
        );
    }

    public int updateFoodWithNewImage(Food food) {
        return jdbcTemplate.update("UPDATE food"
                +" SET name = "+ "'" + food.getName() + "'"
                +", description = '"+ food.getDescription() + "'"
                +", image_link = '"+ food.getImageLink() + "'"
                +", price = "+ food.getPrice()
                +" WHERE id = "+ food.getId()
                +" and is_deleted = 0"
        );
    }
}

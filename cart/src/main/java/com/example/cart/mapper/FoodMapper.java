package com.example.cart.mapper;

import com.example.cart.dto.FoodDto;
import com.example.cart.entity.Food;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodMapper {
    FoodMapper INSTANCE = Mappers.getMapper(FoodMapper.class);

    FoodDto entityToDto(Food food);

    Food dtoToEntity(FoodDto foodDto);
}

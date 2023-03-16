package com.example.managerinfo.mapper;

import com.example.managerinfo.dto.FoodDto;
import com.example.managerinfo.entity.Food;
import com.example.managerinfo.entity.Food;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodMapper {
    FoodMapper INSTANCE = Mappers.getMapper(FoodMapper.class);

    FoodDto entityToDto(Food food);

    Food dtoToEntity(FoodDto foodDto);
}

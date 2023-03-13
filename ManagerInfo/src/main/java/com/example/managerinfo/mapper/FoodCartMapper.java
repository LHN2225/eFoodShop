package com.example.managerinfo.mapper;

import com.example.managerinfo.dto.FoodCartDto;
import com.example.managerinfo.entity.FoodCart;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodCartMapper {
    FoodCartMapper INSTANCE = Mappers.getMapper(FoodCartMapper.class);

    FoodCartDto entityToDto(FoodCart foodCart);

    FoodCart dtoToEntity(FoodCartDto foodCartDto);
}

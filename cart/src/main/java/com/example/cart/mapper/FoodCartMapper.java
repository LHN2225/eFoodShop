package com.example.cart.mapper;


import com.example.cart.dto.FoodCartDto;
import com.example.cart.entity.FoodCart;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodCartMapper {
    FoodCartMapper INSTANCE = Mappers.getMapper(FoodCartMapper.class);

    FoodCartDto entityToDto(FoodCart foodCart);

    FoodCart dtoToEntity(FoodCartDto foodCartDto);
}

package com.example.cart.mapper;

import com.example.cart.dto.CartDto;
import com.example.cart.entity.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface CartMapper {
    CartMapper INSTANCE = Mappers.getMapper(CartMapper.class);

    CartDto entityToDto(Cart foodCart);

    Cart dtoToEntity(CartDto foodCartDto);
}

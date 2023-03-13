package com.example.managerinfo.mapper;

import com.example.managerinfo.dto.UserDto;
import com.example.managerinfo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto entityToDto(User user);

    User dtoToEntity(UserDto userDto);
}

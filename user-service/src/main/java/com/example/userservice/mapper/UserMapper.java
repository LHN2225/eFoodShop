package com.example.userservice.mapper;

import com.example.userservice.dto.UserDto;
import com.example.userservice.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserDto entityToDto(User user);
    User dtoToEntity(UserDto userDto);
    List<UserDto> entityListToDtoList(List<User>userList);
}

package com.example.shipper.mapper;

import com.example.shipper.dto.UserDto;
import com.example.shipper.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public UserDto entityToDto(User user) {
        return new UserDto(user.getEmail(), user.getFullname(), user.getPhone());
    }

    public List<UserDto> entityListToDtoList(List<User> userList) {
        List<UserDto> userDtoList
                = userList.stream().map(user -> this.entityToDto(user)).collect(Collectors.toList());
        return userDtoList;
    }
}

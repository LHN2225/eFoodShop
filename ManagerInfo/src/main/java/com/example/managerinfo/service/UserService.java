package com.example.managerinfo.service;

import com.example.managerinfo.dto.UserDto;

public interface UserService {

    UserDto findByIdAndRoleId(Long userId, String roleName) throws Exception;

    UserDto update(UserDto userDto) throws Exception;
}

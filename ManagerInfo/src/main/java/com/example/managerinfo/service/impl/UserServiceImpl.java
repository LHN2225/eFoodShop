package com.example.managerinfo.service.impl;

import com.example.managerinfo.dto.UserDto;
import com.example.managerinfo.entity.Role;
import com.example.managerinfo.entity.User;
import com.example.managerinfo.mapper.UserMapper;
import com.example.managerinfo.repository.RoleRepository;
import com.example.managerinfo.repository.UserRepository;
import com.example.managerinfo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDto findByIdAndRoleId(Long userId, String roleName) throws Exception {
        Role role = roleRepository.findByRoleName(roleName);
        if (role == null) {
            throw new Exception("There are no role name like this!");
        }
        Long roleId = role.getId();

        User userFromDatabase = userRepository.findByIdAndRoleId(userId, roleId);
        if (userFromDatabase == null) {
            throw new Exception("There are no user with this id");
        }

        return userMapper.entityToDto(userFromDatabase);
    }

    @Override
    public UserDto update(UserDto userDto) throws Exception {
        Optional<User> oldUser = userRepository.findById(userDto.getId());
        if (oldUser.isEmpty()) {
            throw new Exception("There are no users with this id!");
        }

        User updateUser = UserMapper.INSTANCE.dtoToEntity(userDto);

        updateUser.setRoleId(oldUser.get().getRoleId());

        if (updateUser.getEmail() == null || oldUser.get().getEmail().equals(updateUser.getEmail())) {
            updateUser.setEmail(oldUser.get().getEmail());
        }
        if (updateUser.getPassword() == null || oldUser.get().getPassword().equals(updateUser.getPassword())) {
            updateUser.setPassword(oldUser.get().getPassword());
        }
        if (updateUser.getPhone() == null || oldUser.get().getPhone().equals(updateUser.getPhone())) {
            updateUser.setPhone(oldUser.get().getPhone());
        }

        return UserMapper.INSTANCE.entityToDto(userRepository.save(updateUser));
    }
}

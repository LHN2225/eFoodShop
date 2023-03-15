package com.example.userservice.service;

import com.example.userservice.entity.Role;
import com.example.userservice.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
   public List<User> listAll();
   public User get(Long id);
   public List<Role> listRoles();
   public void save(User user);

    public void registerDefaultUser(User user);
    private void encodePassword(User user) {

    }
}

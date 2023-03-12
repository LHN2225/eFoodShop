package com.example.shipper.service;

import com.example.shipper.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> findAll();

    User findByUsername(String username);

    User findById(long id);

    void deleteById(long id);

    void deleteAll();

    User saveUser(User user);

    int updateProfile(Long id, String password, String fullname, String phone);
}

package com.example.shipper.service;

import com.example.shipper.dto.UserDto;
import com.example.shipper.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<UserDto> findAll();

    UserDto findById();

    void deleteById(long id);

    void deleteAll();

    User saveUser(User user);

    int updateProfile(Long id, String fullname, String phone);
}

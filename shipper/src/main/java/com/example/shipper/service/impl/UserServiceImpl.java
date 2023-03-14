package com.example.shipper.service.impl;

import com.example.shipper.entity.User;
import com.example.shipper.repository.UserRepository;
import com.example.shipper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

    @Override
    public User saveUser(User user) {
        return null;
    }

    @Override
    public int updateProfile(Long id, String password, String fullname, String phone) {
        return userRepository.updateProfile(id, password, fullname, phone);
    }
}

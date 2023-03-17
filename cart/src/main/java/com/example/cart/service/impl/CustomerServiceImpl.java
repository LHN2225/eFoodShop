package com.example.cart.service.impl;

import com.example.cart.dto.UserDto;
import com.example.cart.entity.User;
import com.example.cart.mapper.UserMapper;
import com.example.cart.repository.CustomerRepository;
import com.example.cart.repository.RoleRepository;
import com.example.cart.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private RoleRepository repository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public UserDto save(UserDto customerDto) {
        User customer = new User();
        customer.setId(customerDto.getId());
        customer.setEmail(customerDto.getEmail());
        customer.setPassword(customerDto.getPassword());
        customer.setPhone(customerDto.getPhone());
        customer.setRoleId(1L);

        User customerSave = customerRepository.save(customer);
        return UserMapper.INSTANCE.entityToDto(customerSave);
    }

    @Override
    public User findByEmail(String email) {
        return customerRepository.findByEmail(email);
    }


}

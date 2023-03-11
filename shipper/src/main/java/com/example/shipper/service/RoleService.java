package com.example.shipper.service;

import com.example.shipper.entity.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {
    List<Role> findAll();

    List<Role> findByNameContaining(String roleName);

    Role findById(long id);

    void deleteById(long id);

    void deleteAll();

    Role saveRole(Role role);
}

package com.example.shipper.service.impl;

import com.example.shipper.entity.Role;
import com.example.shipper.repository.RoleRepository;
import com.example.shipper.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public List<Role> findByNameContaining(String roleName) {
        return roleRepository.findByRoleNameContainingIgnoreCase(roleName);
    }

    @Override
    public Role findById(long id) {
        return roleRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        roleRepository.deleteAll();
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }
}

package com.example.managerinfo.repository;

import com.example.managerinfo.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByIdAndRoleId(Long userId, Long roleId);
}

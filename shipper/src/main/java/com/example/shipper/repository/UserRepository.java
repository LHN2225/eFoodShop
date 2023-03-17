package com.example.shipper.repository;

import com.example.shipper.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.fullname = :fullname, u.phone = :phone WHERE u.id = :id")
    int updateProfile(
            @Param("id") Long id,
            @Param("fullname") String fullname,
            @Param("phone") String phone
    );
}

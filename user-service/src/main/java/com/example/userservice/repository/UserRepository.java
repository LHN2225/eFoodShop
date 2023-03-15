package com.example.userservice.repository;

import com.example.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
   @Query("SELECT u FROM User u WHERE u.email = ?1")
   public User findByEmail(String email);

   public Optional<User> findById(Long id);
}

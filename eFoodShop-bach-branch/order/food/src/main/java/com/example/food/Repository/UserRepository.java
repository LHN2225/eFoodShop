package com.example.food.Repository;

import com.example.food.DTO.OrderInfoDTO;
import com.example.food.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT new com.example.food.DTO.OrderInfoDTO(o.id, o.shippingStatus) " +
            "FROM User u " +
            "JOIN Cart c ON u.id = c.customerId " +
            "JOIN Order o ON c.id = o.cartId " +
            "WHERE u.id = :id")
    List<OrderInfoDTO> findOrderShippingStatusByUserId(@Param("id") Long id);
}



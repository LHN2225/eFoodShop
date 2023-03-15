package com.example.food.Repository;

import com.example.food.DTO.OrderInfoDTO;
import com.example.food.Entity.Order;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByCartId(Long cartId);
    List<Order> findByCart_CustomerId(Long customerId);
    @Query("SELECT new com.example.demo.dto.OrderInfoDTO(o.orderId, u.fullName, u.phoneNumber, u.address, o.total, o.shippingStatus) FROM Order o JOIN Cart c ON o.cartId = c.cartId JOIN User u ON c.customerId = u.userId WHERE c.customerId = :customerId")
    List<OrderInfoDTO> getOrderByCustomerId(@Param("customerId") Long customerId);
}
package com.example.shipper.repository;

import com.example.shipper.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByShipperId(Long shipperId);

    List<Order> findByShipperIdAndShippingStatus(Long shipperId, String shippingStatus);

    @Modifying
    @Transactional
    @Query("UPDATE Order o SET o.shipperId = :shipperId WHERE o.id = :id")
    int receiveOrderByShipper(@Param("shipperId") Long shipperId, @Param("id") Long id);
}

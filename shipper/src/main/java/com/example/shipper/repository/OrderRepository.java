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

    // Used for search feature
    @Query(value = "SELECT * FROM ORDER_1 WHERE SHIPPER_ID IS NULL AND SHIPPING_STATUS = ?2 AND ID = ?1", nativeQuery = true)
    Order findNotBusyOrderById(Long id, String shippingStatus);

    @Query(value = "SELECT * FROM ORDER_1 WHERE SHIPPER_ID IS NOT NULL AND SHIPPING_STATUS = ?2 AND ID = ?1", nativeQuery = true)
    Order findBusyOrderById(Long id, String shippingStatus);
    // End of used for search feature

    @Query(value = "SELECT * FROM ORDER_1 WHERE SHIPPER_ID IS NULL " +
            "AND SHIPPING_STATUS = ?1 OFFSET (?2 - 1) * ?3 ROWS FETCH NEXT ?3 ROWS ONLY", nativeQuery = true)
    List<Order> findNotBusyOrders(String shippingStatus, int pageNumber, int pageSize);

    @Query(value = "SELECT * FROM ORDER_1 WHERE SHIPPER_ID = ?1 " +
            "AND SHIPPING_STATUS = ?2 OFFSET (?3 - 1) * ?4 ROWS FETCH NEXT ?4 ROWS ONLY", nativeQuery = true)
    List<Order> findByShipperIdAndShippingStatus(Long shipperId, String shippingStatus, int pageNumber, int pageSize);

    @Query(value = "SELECT * FROM ORDER_1 FETCH OFFSET (?1 - 1) * ?2 ROWS FETCH NEXT ?2 ROWS ONLY", nativeQuery = true)
    List<Order> findAll1(int pageNumber, int pageSize);

    @Modifying
    @Transactional
    @Query("UPDATE Order o SET o.shipperId = :shipperId WHERE o.id = :id")
    int receiveOrderByShipper(@Param("shipperId") Long shipperId, @Param("id") Long id);
}

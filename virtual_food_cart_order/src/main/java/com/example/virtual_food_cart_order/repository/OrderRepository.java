package com.example.virtual_food_cart_order.repository;

import com.example.virtual_food_cart_order.entity.Order;
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
    @Query(value = "SELECT * FROM RESTAURANT_ORDER WHERE SHIPPER_ID IS NULL AND SHIPPING_STATUS = ?2 AND ID = ?1 AND RESTAURANT_ORDER.IS_DELETED = 0", nativeQuery = true)
    Order findNotBusyOrderById(Long id, String shippingStatus);

    @Query(value = "SELECT * FROM RESTAURANT_ORDER WHERE SHIPPER_ID IS NOT NULL AND SHIPPING_STATUS = ?2 AND ID = ?1 AND RESTAURANT_ORDER.IS_DELETED = 0", nativeQuery = true)
    Order findBusyOrderById(Long id, String shippingStatus);
    // End of used for search feature

    @Query(value = "SELECT * FROM RESTAURANT_ORDER WHERE SHIPPER_ID IS NULL " +
            "AND SHIPPING_STATUS = ?1 AND RESTAURANT_ORDER.IS_DELETED = 0 OFFSET (?2 - 1) * ?3 ROWS FETCH NEXT ?3 ROWS ONLY", nativeQuery = true)
    List<Order> findNotBusyOrders(String shippingStatus, int pageNumber, int pageSize);

    @Query(value = "SELECT * FROM RESTAURANT_ORDER WHERE SHIPPER_ID = ?1 " +
            "AND SHIPPING_STATUS = ?2 AND RESTAURANT_ORDER.IS_DELETED = 0 OFFSET (?3 - 1) * ?4 ROWS FETCH NEXT ?4 ROWS ONLY", nativeQuery = true)
    List<Order> findByShipperIdAndShippingStatus(Long shipperId, String shippingStatus, int pageNumber, int pageSize);

    @Query(value = "SELECT * FROM RESTAURANT_ORDER AND RESTAURANT_ORDER.IS_DELETED = 0 FETCH OFFSET (?1 - 1) * ?2 ROWS FETCH NEXT ?2 ROWS ONLY", nativeQuery = true)
    List<Order> findAll1(int pageNumber, int pageSize);

    @Modifying
    @Transactional
    @Query("UPDATE Order o SET o.shipperId = :shipperId WHERE o.id = :id AND o.isDeleted = false")
    int receiveOrderByShipper(@Param("shipperId") Long shipperId, @Param("id") Long id);

    @Modifying
    @Transactional
    @Query("UPDATE Order o SET o.shippingStatus = 'DELIVERED' WHERE o.id = :id AND o.isDeleted = false")
    int finishOrder(@Param("id") Long id);
}

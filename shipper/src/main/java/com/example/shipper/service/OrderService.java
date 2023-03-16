package com.example.shipper.service;

import com.example.shipper.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    List<Order> getOrderThatNotBusy();

    List<Order> getNotBusyOrders(int pageNumber);

    List<Order> getInProgressOrders(Long shipperId, int pageNumber);

    List<Order> getDeliveredOrders(Long shipperId, int pageNumber);

    int receiveOrderByShipper(Long shipperId, Long orderId);

    int finishOrder(Long orderId);

    // Used for search feature
    Order findNotBusyOrderById(Long id, String shippingStatus);

    Order findBusyOrderById(Long id, String shippingStatus);
    //... End of used for search feature
}

package com.example.shipper.service;

import com.example.shipper.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    List<Order> getOrderThatNotBusy();

    List<Order> getNotBusyOrders();

    List<Order> getInProgressOrders(Long shipperId);

    List<Order> getDeliveredOrders(Long shipperId);

    int receiveOrderByShipper(Long shipperId, Long orderId);
}

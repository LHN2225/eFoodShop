package com.example.shipper.service.impl;

import com.example.shipper.entity.Order;
import com.example.shipper.repository.OrderRepository;
import com.example.shipper.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getOrderThatNotBusy() {
        return orderRepository.findByShipperId(null);
    }

    @Override
    public List<Order> getNotBusyOrders() {
        return orderRepository.findByShipperIdAndShippingStatus(null, "IN_PROGRESS");
    }

    @Override
    public List<Order> getInProgressOrders(Long shipperId) {
        return orderRepository.findByShipperIdAndShippingStatus(shipperId, "IN_PROGRESS");
    }

    @Override
    public List<Order> getDeliveredOrders(Long shipperId) {
        return orderRepository.findByShipperIdAndShippingStatus(shipperId, "DELIVERED");
    }

    @Override
    public int receiveOrderByShipper(Long shipperId, Long orderId) {
        return orderRepository.receiveOrderByShipper(shipperId, orderId);
    }
}

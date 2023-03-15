package com.example.shipper.service.impl;

import com.example.shipper.entity.Order;
import com.example.shipper.repository.OrderRepository;
import com.example.shipper.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    int pageSize = 5;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getOrderThatNotBusy() {
        return orderRepository.findByShipperId(null);
    }

    @Override
    public List<Order> getNotBusyOrders(int pageNumber) {
        return orderRepository.findNotBusyOrders("IN_PROGRESS", pageNumber, pageSize);
    }

    @Override
    public List<Order> getInProgressOrders(Long shipperId, int pageNumber) {
        return orderRepository.findByShipperIdAndShippingStatus(shipperId, "IN_PROGRESS", pageNumber, pageSize);
    }

    @Override
    public List<Order> getDeliveredOrders(Long shipperId, int pageNumber) {
        return orderRepository.findByShipperIdAndShippingStatus(shipperId, "DELIVERED", pageNumber, pageSize);
    }

    @Override
    public int receiveOrderByShipper(Long shipperId, Long orderId) {
        return orderRepository.receiveOrderByShipper(shipperId, orderId);
    }
}

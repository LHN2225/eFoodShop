package com.example.shipper.service.impl;

import com.example.shipper.config.AppConfig;
import com.example.shipper.entity.Order;
import com.example.shipper.repository.OrderRepository;
import com.example.shipper.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private AppConfig appConfig;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getOrderThatNotBusy() {
        return orderRepository.findByShipperId(null);
    }

    @Override
    public List<Order> getNotBusyOrders(int pageNumber) {
        return orderRepository.findNotBusyOrders("IN_PROGRESS", pageNumber, appConfig.pageSize);
    }

    @Override
    public List<Order> getInProgressOrders(Long shipperId, int pageNumber) {
        return orderRepository.findByShipperIdAndShippingStatus(shipperId, "IN_PROGRESS", pageNumber, appConfig.pageSize);
    }

    @Override
    public List<Order> getDeliveredOrders(Long shipperId, int pageNumber) {
        return orderRepository.findByShipperIdAndShippingStatus(shipperId, "DELIVERED", pageNumber, appConfig.pageSize);
    }

    @Override
    public int receiveOrderByShipper(Long shipperId, Long orderId) {
        return orderRepository.receiveOrderByShipper(shipperId, orderId);
    }

    @Override
    public int finishOrder(Long orderId) {
        return orderRepository.finishOrder(orderId);
    }

    // Used for search feature ...
    @Override
    public Order findNotBusyOrderById(Long id, String shippingStatus) {
        return orderRepository.findNotBusyOrderById(id, shippingStatus);
    }

    @Override
    public Order findBusyOrderById(Long id, String shippingStatus) {
        return orderRepository.findBusyOrderById(id, shippingStatus);
    }
    //... End of used for search feature
}

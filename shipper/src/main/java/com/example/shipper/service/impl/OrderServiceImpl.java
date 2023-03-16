package com.example.shipper.service.impl;

import com.example.shipper.config.AppConfig;
import com.example.shipper.dto.OrderDto;
import com.example.shipper.entity.Order;
import com.example.shipper.mapper.OrderMapper;
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
    private OrderMapper orderMapper;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<OrderDto> getOrderThatNotBusy() {
        return orderMapper.entityListToDtoList(orderRepository.findByShipperId(null));
    }

    @Override
    public List<OrderDto> getNotBusyOrders(int pageNumber) {
        return orderMapper.entityListToDtoList(orderRepository.findNotBusyOrders(
                "IN_PROGRESS",
                pageNumber,
                appConfig.pageSize
        ));
    }

    @Override
    public List<OrderDto> getInProgressOrders(int pageNumber) {
        return orderMapper.entityListToDtoList(orderRepository.findByShipperIdAndShippingStatus(
                appConfig.shipperId,
                "IN_PROGRESS",
                pageNumber,
                appConfig.pageSize
        ));
    }

    @Override
    public List<OrderDto> getDeliveredOrders(int pageNumber) {
        return orderMapper.entityListToDtoList(orderRepository.findByShipperIdAndShippingStatus(
                appConfig.shipperId,
                "DELIVERED",
                pageNumber,
                appConfig.pageSize
        ));
    }

    @Override
    public int receiveOrderByShipper(Long orderId) {
        return orderRepository.receiveOrderByShipper(appConfig.shipperId, orderId);
    }

    @Override
    public int finishOrder(Long orderId) {
        return orderRepository.finishOrder(orderId);
    }

    // Used for search feature ...
    @Override
    public OrderDto findNotBusyOrderById(Long id) {
        Order order = orderRepository.findNotBusyOrderById(id, "IN_PROGRESS");
        if (order != null) {
            return orderMapper.entityToDto(order);
        }
        return null;
    }

    @Override
    public OrderDto findInProgressOrderById(Long id) {
        Order order = orderRepository.findBusyOrderById(id, "IN_PROGRESS");
        if (order != null) {
            return orderMapper.entityToDto(order);
        }
        return null;
    }

    @Override
    public OrderDto findDeliveredOrderById(Long id) {
        Order order = orderRepository.findBusyOrderById(id, "DELIVERED");
        if (order != null) {
            return orderMapper.entityToDto(order);
        }
        return null;
    }
    //... End of used for search feature
}

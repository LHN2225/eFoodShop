package com.example.virtual_food_cart_order.service.impl;

import com.example.virtual_food_cart_order.config.AppConfig;
import com.example.virtual_food_cart_order.dto.OrderDto;
import com.example.virtual_food_cart_order.entity.Order;
import com.example.virtual_food_cart_order.mapper.OrderMapper;
import com.example.virtual_food_cart_order.repository.OrderRepository;
import com.example.virtual_food_cart_order.service.OrderService;
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
                "PENDING",
                pageNumber,
                appConfig.pageSize
        ));
    }

    @Override
    public List<OrderDto> getInProgressOrders(int pageNumber) {
        return orderMapper.entityListToDtoList(orderRepository.findByShipperIdAndShippingStatus(
                appConfig.shipperId,
                "PENDING",
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
        Order order = orderRepository.findNotBusyOrderById(id, "PENDING");
        if (order != null) {
            return orderMapper.entityToDto(order);
        }
        return null;
    }

    @Override
    public OrderDto findInProgressOrderById(Long id) {
        Order order = orderRepository.findBusyOrderById(id, "PENDING");
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

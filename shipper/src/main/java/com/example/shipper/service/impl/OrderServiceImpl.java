package com.example.shipper.service.impl;

import com.example.shipper.config.AppConfig;
import com.example.shipper.dto.OrderDto;
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
                "IN_PROGRESS", pageNumber,
                appConfig.pageSize
        ));
    }

    @Override
    public List<OrderDto> getInProgressOrders(Long shipperId, int pageNumber) {
        return orderMapper.entityListToDtoList(orderRepository.findByShipperIdAndShippingStatus(
                shipperId, "IN_PROGRESS",
                pageNumber, appConfig.pageSize
        ));
    }

    @Override
    public List<OrderDto> getDeliveredOrders(Long shipperId, int pageNumber) {
        return orderMapper.entityListToDtoList(orderRepository.findByShipperIdAndShippingStatus(
                shipperId,
                "DELIVERED",
                pageNumber,
                appConfig.pageSize
        ));
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
    public OrderDto findNotBusyOrderById(Long id, String shippingStatus) {
        return orderMapper.entityToDto(orderRepository.findNotBusyOrderById(id, shippingStatus));
    }

    @Override
    public OrderDto findBusyOrderById(Long id, String shippingStatus) {
        return orderMapper.entityToDto(orderRepository.findBusyOrderById(id, shippingStatus));
    }
    //... End of used for search feature
}

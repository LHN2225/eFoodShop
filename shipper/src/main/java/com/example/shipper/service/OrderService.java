package com.example.shipper.service;

import com.example.shipper.dto.OrderDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    List<OrderDto> getOrderThatNotBusy();

    List<OrderDto> getNotBusyOrders(int pageNumber);

    List<OrderDto> getInProgressOrders(int pageNumber);

    List<OrderDto> getDeliveredOrders(int pageNumber);

    int receiveOrderByShipper(Long orderId);

    int finishOrder(Long orderId);

    // Used for search feature
    OrderDto findNotBusyOrderById(Long id);

    OrderDto findInProgressOrderById(Long id);

    OrderDto findDeliveredOrderById(Long id);
    //... End of used for search feature
}

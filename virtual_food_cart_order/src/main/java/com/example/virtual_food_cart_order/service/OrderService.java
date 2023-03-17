package com.example.virtual_food_cart_order.service;

import com.example.virtual_food_cart_order.dto.OrderDto;
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

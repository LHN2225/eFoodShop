package com.example.shipper.service;

import com.example.shipper.dto.OrderDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    List<OrderDto> getOrderThatNotBusy();

    List<OrderDto> getNotBusyOrders(int pageNumber);

    List<OrderDto> getInProgressOrders(Long shipperId, int pageNumber);

    List<OrderDto> getDeliveredOrders(Long shipperId, int pageNumber);

    int receiveOrderByShipper(Long shipperId, Long orderId);

    int finishOrder(Long orderId);

    // Used for search feature
    OrderDto findNotBusyOrderById(Long id, String shippingStatus);

    OrderDto findBusyOrderById(Long id, String shippingStatus);
    //... End of used for search feature
}

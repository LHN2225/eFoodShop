package com.example.shipper.mapper;

import com.example.shipper.dto.OrderDto;
import com.example.shipper.entity.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {
    public OrderDto entityToDto(Order order) {
        return new OrderDto(order.getId(), order.getAddress());
    }

    public List<OrderDto> entityListToDtoList(List<Order> orderList) {
        List<OrderDto> orderDtoList
                = orderList.stream().map(order -> this.entityToDto(order)).collect(Collectors.toList());
        return orderDtoList;
    }
}

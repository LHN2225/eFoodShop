package com.example.virtual_food_cart_order.mapper;

import com.example.virtual_food_cart_order.dto.OrderDto;
import com.example.virtual_food_cart_order.entity.Order;
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

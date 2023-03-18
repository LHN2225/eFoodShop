package com.example.virtual_food_cart_order.service.impl;

import com.example.virtual_food_cart_order.dto.OrderDetailDto;
import com.example.virtual_food_cart_order.repository.OrderDetailFoodRepository;
import com.example.virtual_food_cart_order.repository.OrderDetailRepository;
import com.example.virtual_food_cart_order.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderDetailFoodRepository orderDetailFoodRepository;

    @Override
    public OrderDetailDto getOrderDetailById(Long orderId) {
        OrderDetailDto orderDetail = orderDetailRepository.findByOrderId(orderId);
        if (orderDetail != null) {
            orderDetail.setFoods(orderDetailFoodRepository.findByOrderId(orderId));
        } else {
            orderDetail = new OrderDetailDto(-1L, "", "", "", "");
            orderDetail.setFoods(new ArrayList<>());
        }
        System.out.println(orderDetail);
        return orderDetail;
    }
}

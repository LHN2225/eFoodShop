package com.example.shipper.service.impl;

import com.example.shipper.dto.OrderDetailDto;
import com.example.shipper.dto.OrderDetailFoodDto;
import com.example.shipper.repository.OrderDetailFoodRepository;
import com.example.shipper.repository.OrderDetailRepository;
import com.example.shipper.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderDetailFoodRepository orderDetailFoodRepository;

    @Override
    public OrderDetailDto getOrderDetailById(Long orderId) {
        OrderDetailDto orderDetail = orderDetailRepository.findByOrderId(orderId);
        orderDetail.setFoods(orderDetailFoodRepository.findByOrderId(orderId));
        return orderDetail;
    }
}

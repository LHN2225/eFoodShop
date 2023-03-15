package com.example.shipper.service.impl;

import com.example.shipper.dto.OrderDetailDto;
import com.example.shipper.repository.OrderDetailRepository;
import com.example.shipper.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public OrderDetailDto getOrderDetailById(Long orderId) {
        return orderDetailRepository.findByOrderId(orderId);
    }
}

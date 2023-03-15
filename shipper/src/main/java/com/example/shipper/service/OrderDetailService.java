package com.example.shipper.service;

import com.example.shipper.dto.OrderDetailDto;
import org.springframework.stereotype.Service;

@Service
public interface OrderDetailService {
    OrderDetailDto getOrderDetailById(Long orderId);
}

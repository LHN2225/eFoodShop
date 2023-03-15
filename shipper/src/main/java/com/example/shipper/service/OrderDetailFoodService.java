package com.example.shipper.service;

import com.example.shipper.dto.OrderDetailFoodDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderDetailFoodService {
    List<OrderDetailFoodDto> getFoodsByOrderId(Long orderId);
}

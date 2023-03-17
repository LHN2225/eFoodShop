package com.example.virtual_food_cart_order.service;

import org.springframework.stereotype.Service;

@Service
public interface PageService {
    int findNotBusyOrderTotalPageNumber();

    int findInProgressOrderTotalPageNumber();

    int findDeliveredOrderTotalPageNumber();
}

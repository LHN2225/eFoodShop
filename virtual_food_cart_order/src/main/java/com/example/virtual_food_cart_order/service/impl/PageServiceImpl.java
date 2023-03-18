package com.example.virtual_food_cart_order.service.impl;

import com.example.virtual_food_cart_order.config.AppConfig;
import com.example.virtual_food_cart_order.repository.PageRepository;
import com.example.virtual_food_cart_order.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PageServiceImpl implements PageService {

    @Autowired
    private PageRepository pageRepository;

    @Autowired
    private AppConfig appConfig;

    @Override
    public int findNotBusyOrderTotalPageNumber() {
        return pageRepository.findNotBusyOrderTotalPageNumber("PENDING", appConfig.pageSize);
    }

    @Override
    public int findInProgressOrderTotalPageNumber() {
        return pageRepository.findInProgressOrderTotalPageNumber(appConfig.shipperId, "PENDING", appConfig.pageSize);
    }

    @Override
    public int findDeliveredOrderTotalPageNumber() {
        return pageRepository.findDeliveredOrderTotalPageNumber(appConfig.shipperId, "DELIVERED", appConfig.pageSize);
    }
}

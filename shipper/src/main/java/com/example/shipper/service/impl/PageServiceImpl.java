package com.example.shipper.service.impl;

import com.example.shipper.config.AppConfig;
import com.example.shipper.repository.PageRepository;
import com.example.shipper.service.PageService;
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
        return pageRepository.findNotBusyOrderTotalPageNumber("IN_PROGRESS", appConfig.pageSize);
    }

    @Override
    public int findInProgressOrderTotalPageNumber() {
        return pageRepository.findInProgressOrderTotalPageNumber(appConfig.shipperId, "IN_PROGRESS", appConfig.pageSize);
    }

    @Override
    public int findDeliveredOrderTotalPageNumber() {
        return pageRepository.findDeliveredOrderTotalPageNumber(appConfig.shipperId, "DELIVERED", appConfig.pageSize);
    }
}

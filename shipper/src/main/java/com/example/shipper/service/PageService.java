package com.example.shipper.service;

import org.springframework.stereotype.Service;

@Service
public interface PageService {
    int findNotBusyOrderTotalPageNumber();

    int findInProgressOrderTotalPageNumber();

    int findDeliveredOrderTotalPageNumber();
}

package com.example.virtual_food_cart_order.controller;

import com.example.virtual_food_cart_order.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/page")
public class PageController {

    @Autowired
    private PageService pageService;

    @GetMapping("/not-busy")
    public ResponseEntity<Integer> findNotBusyOrderTotalPageNumber() {
        try {
            int response = pageService.findNotBusyOrderTotalPageNumber();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/in-progress")
    public ResponseEntity<Integer> findInProgressOrderTotalPageNumber() {
        try {
            int response = pageService.findInProgressOrderTotalPageNumber();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/delivered")
    public ResponseEntity<Integer> findDeliveredOrderTotalPageNumber() {
        try {
            int response = pageService.findDeliveredOrderTotalPageNumber();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

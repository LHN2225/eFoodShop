package com.example.shipper.controller;

import com.example.shipper.config.AppConfig;
import com.example.shipper.dto.OrderDto;
import com.example.shipper.dto.UserDto;
import com.example.shipper.entity.Order;
import com.example.shipper.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/test/")
public class TestController2 {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AppConfig appConfig;

    @GetMapping(value = "/order/not-busy/{pageNumber}")
    public List<OrderDto> getProductList(@PathVariable int pageNumber) {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<OrderDto>> responseEntity = restTemplate.exchange(
                appConfig.hostname + "/api/order/not-busy/1",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<OrderDto>>() {}
        );

        List<OrderDto> orderDtoList = responseEntity.getBody();
        return orderDtoList;
    }
}

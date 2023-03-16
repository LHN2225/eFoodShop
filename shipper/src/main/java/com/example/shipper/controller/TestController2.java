package com.example.shipper.controller;

import com.example.shipper.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/test/")
public class TestController2 {
    /*@Autowired
    private RestTemplate restTemplate;*/

    /*@GetMapping(value = "/order/not-busy/{pageNumber}")
    public String getProductList(@PathVariable int pageNumber) {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<List<Order>> entity = new HttpEntity<List<Order>>(headers);

        String urlTemplate = "http://localhost:8080/api/order/not-busy/%d";
        String url = String.format(urlTemplate, pageNumber);

        return restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody();
    }*/
}

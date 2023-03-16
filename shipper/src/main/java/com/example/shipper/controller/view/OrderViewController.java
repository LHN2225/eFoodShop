package com.example.shipper.controller.view;

import java.util.ArrayList;
import java.util.List;

import com.example.shipper.config.AppConfig;
import com.example.shipper.dto.OrderDto;
import com.example.shipper.repository.PageRepository;
import com.example.shipper.service.OrderDetailFoodService;
import com.example.shipper.service.OrderDetailService;
import com.example.shipper.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.shipper.dto.OrderDetailDto;
import com.example.shipper.service.OrderService;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/shipper/order")
public class OrderViewController {

    @Autowired
    private AppConfig appConfig;
    
    @GetMapping("/in-progress")
    public String getInProgressOrdersPage(Model model) {
        // Rest template ...
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Integer> responseEntity = restTemplate.getForEntity(
                appConfig.hostname + "/api/page/in-progress",
                Integer.class
        );
        int totalPageNumber = responseEntity.getBody();
        // ...

        int[] paginationItems = new int[totalPageNumber];
        for (int i = 1; i <= totalPageNumber; i++) {
            paginationItems[i-1] = i;
        }
        model.addAttribute("paginationItems", paginationItems);
        return "in-progress-order";
    }

    @GetMapping("/delivered")
    public String getDeliveredOrdersPage(Model model) {
        // Rest template ...
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Integer> responseEntity = restTemplate.getForEntity(
                appConfig.hostname + "/api/page/delivered",
                Integer.class
        );
        int totalPageNumber = responseEntity.getBody();
        // ...

        int[] paginationItems = new int[totalPageNumber];
        for (int i = 1; i <= totalPageNumber; i++) {
            paginationItems[i-1] = i;
        }
        model.addAttribute("paginationItems", paginationItems);
        return "delivered-order";
    }

    @GetMapping("/fragment/not-busy/{isSearch}/{orderId}/{pageNumber}")
    public String getNotBusyOrders(
        Model model,
        @PathVariable int isSearch,
        @PathVariable Long orderId,
        @PathVariable int pageNumber
    ) {
        // Rest template ...
        RestTemplate restTemplate = new RestTemplate();

        String urlTepmlate = appConfig.hostname + "/api/order/not-busy/%d/%s/%d";
        String url = String.format(urlTepmlate, isSearch, String.valueOf(orderId), pageNumber);

        ResponseEntity<List<OrderDto>> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<OrderDto>>() {}
        );

        List<OrderDto> orderDtoList = responseEntity.getBody();
        // ...

        model.addAttribute("orders", orderDtoList);
        return "fragment/not-busy-orders";
    }

    @GetMapping("/fragment/in-progress/{isSearch}/{orderId}/{pageNumber}")
    public String getInProgressOrders(
        Model model,
        @PathVariable int isSearch,
        @PathVariable Long orderId,
        @PathVariable int pageNumber
    ) {
        // Rest template ...
        RestTemplate restTemplate = new RestTemplate();

        String urlTepmlate = appConfig.hostname + "/api/order/in-progress/%d/%s/%d";
        String url = String.format(urlTepmlate, isSearch, String.valueOf(orderId), pageNumber);

        ResponseEntity<List<OrderDto>> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<OrderDto>>() {}
        );

        List<OrderDto> orderDtoList = responseEntity.getBody();
        // ...

        model.addAttribute("orders", orderDtoList);
        return "fragment/in-progress-orders-box";
    }

    @GetMapping("/fragment/delivered/{isSearch}/{orderId}/{pageNumber}")
    public String getDeliveredOrders(
        Model model,
        @PathVariable int isSearch,
        @PathVariable Long orderId,
        @PathVariable int pageNumber
    ) {
        // Rest template ...
        RestTemplate restTemplate = new RestTemplate();

        String urlTepmlate = appConfig.hostname + "/api/order/delivered/%d/%s/%d";
        String url = String.format(urlTepmlate, isSearch, String.valueOf(orderId), pageNumber);

        ResponseEntity<List<OrderDto>> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<OrderDto>>() {}
        );

        List<OrderDto> orderDtoList = responseEntity.getBody();
        // ...

        model.addAttribute("orders", orderDtoList);
        return "fragment/delivered-orders-box";
    }

    @GetMapping("/{orderId}")
    public String getOrderDetail(Model model, @PathVariable Long orderId) {
        // Rest template ...
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<OrderDetailDto> responseEntity = restTemplate.getForEntity(
                appConfig.hostname + "/api/order/" + orderId,
                OrderDetailDto.class
        );
        OrderDetailDto orderDetail = responseEntity.getBody();
        // ...

        model.addAttribute("orderDetail", orderDetail);
        model.addAttribute("foods", orderDetail.getFoods());
        return "order-detail";
    }

}

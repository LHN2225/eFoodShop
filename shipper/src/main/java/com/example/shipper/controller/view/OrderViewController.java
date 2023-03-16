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
    
    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private OrderDetailFoodService orderDetailFoodService;

    @Autowired
    private PageService pageService;

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
        List<OrderDto> orderDtoList = new ArrayList<>();
        if (isSearch == 0) {
            orderDtoList = orderService.getNotBusyOrders(pageNumber);
        } else {
            OrderDto orderDto = orderService.findNotBusyOrderById(orderId);
            if (orderDto != null) {
                orderDtoList.add(orderDto);
            }
        }
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
        List<OrderDto> orderDtoList = new ArrayList<>();
        if (isSearch == 0) {
            orderDtoList = orderService.getInProgressOrders(pageNumber);
        } else {
            OrderDto orderDto = orderService.findInProgressOrderById(orderId);
            if (orderDto != null) {
                orderDtoList.add(orderDto);
            }
        }
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
        List<OrderDto> orderDtoList = new ArrayList<>();
        if (isSearch == 0) {
            orderDtoList = orderService.getDeliveredOrders(pageNumber);
        } else {
            OrderDto order = orderService.findDeliveredOrderById(orderId);
            if (order != null) {
                orderDtoList.add(order);
            }
        }
        model.addAttribute("orders", orderDtoList);
        return "fragment/delivered-orders-box";
    }

    @GetMapping("/{orderId}")
    public String getORderDetail(Model model, @PathVariable Long orderId) {
        OrderDetailDto orderDetail = orderDetailService.getOrderDetailById(orderId);
        model.addAttribute("orderDetail", orderDetail);
        model.addAttribute("foods", orderDetail.getFoods());
        return "order-detail";
    }

}

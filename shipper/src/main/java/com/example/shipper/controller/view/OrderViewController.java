package com.example.shipper.controller.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.shipper.config.VirtualFoodCartOrderConfig;
import com.example.shipper.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.shipper.dto.OrderDetailDto;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/shipper/order")
public class OrderViewController {

    @Autowired
    private VirtualFoodCartOrderConfig virtualFoodCartOrderConfig;

    @GetMapping("/in-progress")
    public String getInProgressOrdersPage(Model model) {
        // Rest template ...
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Integer> responseEntity = restTemplate.getForEntity(
                virtualFoodCartOrderConfig.getDomain() + "/api/page/in-progress",
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
                virtualFoodCartOrderConfig.getDomain() + "/api/page/delivered",
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

        String urlTepmlate = virtualFoodCartOrderConfig.getDomain() + "/api/order/not-busy/%d/%s/%d";
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

        String urlTepmlate = virtualFoodCartOrderConfig.getDomain() + "/api/order/in-progress/%d/%s/%d";
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

        String urlTepmlate = virtualFoodCartOrderConfig.getDomain() + "/api/order/delivered/%d/%s/%d";
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
                virtualFoodCartOrderConfig.getDomain() + "/api/order/" + orderId,
                OrderDetailDto.class
        );
        OrderDetailDto orderDetail = responseEntity.getBody();
        // ...

        model.addAttribute("orderDetail", orderDetail);
        model.addAttribute("foods", orderDetail.getFoods());
        return "order-detail";
    }
	
	@PutMapping("/receive")
	@ResponseBody
    public ResponseEntity<Integer> receiveOrderByShipper(@RequestParam Long orderId) {
			try {
				// Rest template ...
				RestTemplate restTemplate = new RestTemplate();

                ResponseEntity<Integer> responseEntity = restTemplate.exchange(
                    virtualFoodCartOrderConfig.getDomain() + "/api/order/shipper/" + orderId,
                    HttpMethod.PUT,
                    null,
                    Integer.class
                );

				int response = responseEntity.getBody();
				// ...
			
				//int response = orderService.receiveOrderByShipper(orderId);
				return new ResponseEntity<>(response, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
    }

    @PutMapping("/finish")
	@ResponseBody
    public ResponseEntity<Integer> finishOrder(@RequestParam Long orderId) {
        try {
			// Rest template ...
            RestTemplate restTemplate = new RestTemplate();

            ResponseEntity<Integer> responseEntity = restTemplate.exchange(
                virtualFoodCartOrderConfig.getDomain() + "/api/order/shipper/finish/" + orderId,
                HttpMethod.PUT,
                null,
                Integer.class
            );

            int response = responseEntity.getBody();
            // ...
			
			//int response = orderService.finishOrder(orderId);
			return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

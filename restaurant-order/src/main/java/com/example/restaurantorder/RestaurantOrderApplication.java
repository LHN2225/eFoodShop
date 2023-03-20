package com.example.restaurantorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RestaurantOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestaurantOrderApplication.class, args);
    }

}

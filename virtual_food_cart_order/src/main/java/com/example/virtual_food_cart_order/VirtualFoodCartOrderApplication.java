package com.example.virtual_food_cart_order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class VirtualFoodCartOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(VirtualFoodCartOrderApplication.class, args);
	}

}

package com.example.virtual_food_cart_order.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
    public Long shipperId = 1L;

    @Value("${app-config.virtual_food_cart_order.page-size}")
    public int pageSize;

    @Value("${app-config.virtual_food_cart_order.port}")
    public String port;

    @Value("${app-config.virtual_food_cart_order.hostname}")
    public String hostname;

    public String getDomain() {
        return this.hostname + ":" + this.port;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

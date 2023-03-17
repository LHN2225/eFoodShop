package com.example.shipper.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VirtualFoodCartOrderConfig {
    @Value("${app-config.virtual_food_cart_order.port}")
    public String port;

    @Value("${app-config.virtual_food_cart_order.hostname}")
    public String hostname;

    public String getDomain() {
        return this.hostname + ":" + this.port;
    }
}

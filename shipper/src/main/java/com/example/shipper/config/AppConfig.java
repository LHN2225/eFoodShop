package com.example.shipper.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
    public Long shipperId = 1L;

    @Value("${app-config.shipper.page-size}")
    public int pageSize;

    @Value("${app-config.shipper.port}")
    public String port;

    @Value("${app-config.shipper.hostname}")
    public String hostname;

    public String getDomain() {
        return this.hostname + ":" + this.port;
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

package com.example.shipper.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
    public int pageSize = 5;
    public Long shipperId = 1L;
    public String hostname = "http://localhost:8080";

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

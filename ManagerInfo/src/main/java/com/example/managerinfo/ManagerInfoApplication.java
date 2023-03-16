package com.example.managerinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ManagerInfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagerInfoApplication.class, args);
    }

//    TODO: Make the get quantity in cart more global in FE

}

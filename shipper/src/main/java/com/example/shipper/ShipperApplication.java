package com.example.shipper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class ShipperApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShipperApplication.class, args);
	}

}

package com.example.foodInventoryService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FoodInventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodInventoryServiceApplication.class, args);
	}

}

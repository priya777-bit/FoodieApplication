package com.example.addRestuarantService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AddRestuarantServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddRestuarantServiceApplication.class, args);
	}

}

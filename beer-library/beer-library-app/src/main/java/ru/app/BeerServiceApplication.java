package ru.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BeerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeerServiceApplication.class);
		System.out.println("beer-library-app:8080");
	}

}
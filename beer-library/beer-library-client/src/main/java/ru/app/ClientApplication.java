package ru.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class ClientApplication {

	public static void main(String[] args)  {
		SpringApplication.run(ClientApplication.class);
		System.out.println("beer-library-client:8081");
		System.out.printf("Чтобы перейти на страницу сайта открывай: %n%s%n",
				"http://localhost:8081/library");
		System.out.println("adm:pwd");
		System.out.println("usr:pwd");

	}
}
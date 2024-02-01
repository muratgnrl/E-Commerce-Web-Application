package com.example.stoks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@EnableDiscoveryClient
@SpringBootApplication
public class StoksApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoksApplication.class, args);
	}

}

package com.coforge.serviceresgistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer 
public class SbMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbMicroServiceApplication.class, args);
	}

}

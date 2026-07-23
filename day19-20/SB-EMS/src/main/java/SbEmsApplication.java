package com.coforge.ems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// starting point of the application 
// this is the main method 
// because we can also create console application, we have a main method also 
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

// annotation to specify the main class 
// springboot application -- @configuration (to create the dependent object / bean object),
// @enableautocongifuration, @componentscan (automatiicaly scans the base package) 
//@Configuration
// Marks the class as a source of Spring bean definitions.
// Allows you to define beans using @Bean methods.
//@EnableAutoConfiguration
// Tells Spring Boot to automatically configure your application based on the
// dependencies available in the classpath.

// @ComponentScan - in dispatcher servelet file 
// Scans the package of the annotated class
// @Component @Service @Repository @Controller @RestController


@SpringBootApplication 
@EnableDiscoveryClient
@EnableFeignClients
public class SbEmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbEmsApplication.class, args);
	}

}










package com.spring.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MyBootApplicationGateway {    
	
    public static void main(String[] args) {
        SpringApplication.run(MyBootApplicationGateway.class, args);
    }
       
}

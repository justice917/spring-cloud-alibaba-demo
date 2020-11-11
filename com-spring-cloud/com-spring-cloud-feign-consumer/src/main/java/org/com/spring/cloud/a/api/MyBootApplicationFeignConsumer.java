package org.com.spring.cloud.a.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class MyBootApplicationFeignConsumer {    
	
    public static void main(String[] args) {
        SpringApplication.run(MyBootApplicationFeignConsumer.class, args);
    }
       
}

package org.com.spring.cloud.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
public class MyBootApplicationDubboConsumer {    
	
    public static void main(String[] args) {
        SpringApplication.run(MyBootApplicationDubboConsumer.class, args);
    }
       
}

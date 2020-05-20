package com.boot.create;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MyBootApplicationB {

    public static void main(String[] args) {
        SpringApplication.run(MyBootApplicationB.class, args);
    }

}

package com.example.javaapr2025springcontroller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class JavaApr2025SpringControllerApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaApr2025SpringControllerApplication.class, args);
    }

}

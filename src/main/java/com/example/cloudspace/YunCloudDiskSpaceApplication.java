package com.example.cloudspace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class YunCloudDiskSpaceApplication {
    public static void main(String[] args) {
        SpringApplication.run(YunCloudDiskSpaceApplication.class, args);
    }
} 
package com.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Home4UApplication {

    public static void main(String[] args) {
        SpringApplication.run(Home4UApplication.class, args);
    }

}

package com.example.spring_rbac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
@EnableMongoRepositories
public class SpringRbacApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringRbacApplication.class, args);
    }

}

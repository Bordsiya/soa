package com.example.secondservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SecondServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecondServiceApplication.class, args);
    }

}

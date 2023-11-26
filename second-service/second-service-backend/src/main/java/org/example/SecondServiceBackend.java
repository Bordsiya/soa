package org.example;

import lombok.SneakyThrows;
import org.example.ejb.service.RestClientService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;
import java.util.Properties;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SecondServiceBackend extends SpringBootServletInitializer {
    @SneakyThrows
    public static void main(String[] args) {
        SpringApplication.run(SecondServiceBackend.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SecondServiceBackend.class);
    }
}
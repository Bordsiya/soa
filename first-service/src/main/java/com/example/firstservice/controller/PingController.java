package com.example.firstservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PingController {
    @Value("${server.port}")
    private String port;

    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        log.info("/ping");
        return ResponseEntity.ok(
                "Hello from first service, which running on the " + port + " port!"
        );
    }

    @GetMapping("/")
    public ResponseEntity<String> emptyRequest() {
        log.info("/ <- (default)");
        return ResponseEntity.ok(
                "Hello from first service, which running on the " + port + " port!"
        );
    }

}

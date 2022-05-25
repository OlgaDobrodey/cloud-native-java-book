package com.example.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class Controller {

    @Value("${message:Hello default}")
    private String message;
    @Value("${my.greeting}")
    private String greeting;

    @RequestMapping("/")
    public String home() {
        return "Hello World!";
    }

    @RequestMapping("/greeting")
    String getGreeting() {
        return this.greeting;
    }

    @RequestMapping("/message")
    String getMessage() {
        return this.message;
    }
}


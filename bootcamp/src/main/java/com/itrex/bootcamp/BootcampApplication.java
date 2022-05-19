package com.itrex.bootcamp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootcampApplication implements CommandLineRunner {

    @Value("${mail.hostname}")
    private String hostname;
    @Value("${spring.message}")
    private String message;

    public static void main(String[] args) {
        SpringApplication.run(BootcampApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println(hostname);
        System.out.println(message);
    }
}

package com.itrex.bootcamp.controller;

import com.itrex.bootcamp.model.Customer;
import com.itrex.bootcamp.service.CustomerServer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerServer service;

    @GetMapping("/customer")
    public ResponseEntity<List<Customer>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

}

package com.itrex.bootcamp.service;

import com.itrex.bootcamp.model.Customer;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

public interface CustomerServer {

    List<Customer> findAll();

    Optional<Customer> findById(Long id);

    String findNameOfCustomerById(Long Id);

    Customer findCustomerByPrincipal(Principal principal);

    Customer updateCustomer(Customer customer);

    Customer addCustomer(Customer customer);

}

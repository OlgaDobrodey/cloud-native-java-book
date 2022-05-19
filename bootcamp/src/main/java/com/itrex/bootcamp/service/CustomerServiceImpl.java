package com.itrex.bootcamp.service;

import com.itrex.bootcamp.model.Customer;
import com.itrex.bootcamp.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerServer {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public String findNameOfCustomerById(Long id) {
        return findById(id).get().getName();
    }

    @Override
    public Customer findCustomerByPrincipal(Principal principal) {
        return Optional.ofNullable(principal)
                .map(p -> customerRepository.findCustomerByName(p.getName()))
                .orElse(null);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        findById(customer.getId()).orElseThrow(() -> new RuntimeException("Custom this Id is non"));
        return customerRepository.save(customer);
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}

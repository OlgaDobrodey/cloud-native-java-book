package com.itrex.bootcamp.service;

import com.itrex.bootcamp.model.Customer;
import com.itrex.bootcamp.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

    @Mock
    private CustomerRepository repository;
    @InjectMocks
    private CustomerServiceImpl server;

    private final Customer OLGA = new Customer(1L, "olga@mail.com", "olga");
    private final Customer KATE = new Customer(2L, "kate@mail.com", "kate");

    @Test
    void findAll() {
        //given
        when(this.repository.findAll()).thenReturn(List.of(OLGA, KATE));

        //when
        List<Customer> serverAll = server.findAll();

        //then
        assertEquals(serverAll.size(), 2);
        assertEquals(serverAll.get(0), OLGA);
        assertEquals(serverAll.get(1), KATE);
    }

    @Test
    void findById() {
        //given
        Long id = 1L;
        when(repository.findById(1L)).thenReturn(Optional.of(OLGA));
        //when
        Optional<Customer> byId = server.findById(id);
        //then
        assertEquals(byId.get(), OLGA);
    }

    @Test
    void findNameOfCustomerById() {
        //given
        Long id = 1L;
        given(repository.findById(id)).willReturn(Optional.of(OLGA));

        //when
        String name = server.findNameOfCustomerById(id);

        //then
        assertEquals(name, OLGA.getName());
    }

    @Test
    void updateCustomer() {
        //given
        Customer customer = OLGA;
        customer.setName("OLGA");
        given(repository.findById(customer.getId())).willReturn(Optional.of(customer));
        given(repository.save(customer)).willReturn(customer);
        //when
        Customer updateCustomer = server.updateCustomer(customer);
        //then
        assertEquals(updateCustomer.getName(), customer.getName());
        assertEquals(updateCustomer.getId(), customer.getId());
        assertEquals(updateCustomer.getEmail(), customer.getEmail());
    }

    @Test
    void addCustomer() {
        //given
        Customer customer = OLGA;
        customer.setName("OLGA");
        given(repository.save(customer)).willReturn(customer);
        //when
        Customer addCustomer = server.addCustomer(customer);
        //then
        assertEquals(addCustomer.getName(), customer.getName());
        assertEquals(addCustomer.getId(), customer.getId());
        assertEquals(addCustomer.getEmail(), customer.getEmail());
    }
}
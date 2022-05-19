package com.itrex.bootcamp.controllerHTTP;

import com.itrex.bootcamp.model.Customer;
import com.itrex.bootcamp.service.CustomerServer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class TestingWebApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerServer server;

    private Customer olga = new Customer(1l, "olga@mail.com", "olga");
    private Customer kate = new Customer(2l, "kate@mail.com", "kate");

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc
                .perform(get("/"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content()
                        .string(containsString("Hello, World")));
    }

    @Test
    public void shouldReturnListAllCustomer() throws Exception {
        List<Customer> customers = List.of(this.olga, kate);
        when(server.findAll()).thenReturn(customers);


        this.mockMvc
                .perform(get("/customer"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content()
                        .string(containsString("[{\"id\":1,\"email\":\"olga@mail.com\",\"name\":\"olga\"},{\"id\":2,\"email\":\"kate@mail.com\",\"name\":\"kate\"}]")))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].email", is("olga@mail.com")));


    }
}

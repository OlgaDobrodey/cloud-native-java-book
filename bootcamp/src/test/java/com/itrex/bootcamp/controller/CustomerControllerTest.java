package com.itrex.bootcamp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itrex.bootcamp.model.Customer;
import com.itrex.bootcamp.service.CustomerServer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CustomerServer customerServer;

    private Customer olga = new Customer(1L, "olga@mail.com", "olga");
    private Customer kate = new Customer(2L, "kate@mail.com", "kate");

    @BeforeEach
    void setUp() {
    }

    @Test
    void findAll() throws Exception {
//        //given
        List<Customer> customers = List.of(olga, kate);
        when(customerServer.findAll()).thenReturn(customers);

//        //when
        MvcResult mvcResult = mockMvc.perform(get("/customer")
                        .contentType("application/json"))
                .andReturn();

//        //then
        MockHttpServletResponse response = mvcResult.getResponse();
        assertEquals(HttpServletResponse.SC_OK, response.getStatus());
        List<Customer> result = objectMapper.readValue(response.getContentAsString(), ArrayList.class);
        assertEquals(
                "[{id=1, email=olga@mail.com, name=olga}, {id=2, email=kate@mail.com, name=kate}]",
                result.toString());

        verify(customerServer).findAll();
    }

    @Test
    void findAll_second() throws Exception {
        //given && when
        String content = "[{\"id\":1," +
                "\"email\":\"olga@mail.com\"," +
                "\"name\":\"olga\"}]";
        List<Customer> customers = List.of(olga);
        given(customerServer.findAll()).willReturn(Collections.singletonList(olga));

        //then
        mockMvc.perform(get("/customer")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(content));
    }

    @Test
    void findAll_third() throws Exception {
        //given && when
        String content = "[{\"id\":1," +
                "\"email\":\"olga@mail.com\"," +
                "\"name\":\"olga\"}]";
        given(customerServer.findAll()).willReturn(Collections.singletonList(olga));

        //then
//        <[{"id":1,"email":"olga@mail.com","name":"olga"}]>
        mockMvc.perform(get("/customer")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(content().string(content))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].email", is("olga@mail.com")))
                .andExpect(jsonPath("$[0].name", is("olga")));
    }
}
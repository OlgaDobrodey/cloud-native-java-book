package com.itrex.bootcamp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.springframework.test.util.AssertionErrors.assertNotNull;

@SpringBootTest
class BootcampApplicationTests {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void contextLoads() {
        assertNotNull("the application context should have loaded.", this.applicationContext);
    }

}

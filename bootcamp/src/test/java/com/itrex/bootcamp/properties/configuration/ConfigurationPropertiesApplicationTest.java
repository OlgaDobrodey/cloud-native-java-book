package com.itrex.bootcamp.properties.configuration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConfigurationPropertiesApplicationTest extends BaseConfigurationTest {

    @Value("${mail.hostname}")
    private String host;
    @Value("${mail.port}")
    private int port;
    @Value("${mail.from}")
    private String from;

    @Test
    void getProperties() {
        //given && when && then
        assertEquals(host, "mailer@mail.com");
        assertEquals(port, 9000);
        assertEquals(from, "mailer@mail.com");
    }

}

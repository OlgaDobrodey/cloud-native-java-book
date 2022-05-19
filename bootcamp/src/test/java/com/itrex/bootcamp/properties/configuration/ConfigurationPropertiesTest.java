package com.itrex.bootcamp.properties.configuration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConfigurationPropertiesTest extends BaseConfigurationTest {

    @Autowired
    ConfigProperties configurationProjectProperties;

    @Test
    void getProjectName_returnString() {
        //given && when
        String messageProjectName = "ProjectName-Test";
        //then
        assertEquals(messageProjectName, configurationProjectProperties.getProjectName());
    }

    @Test
    void getProperties_returnStringTest() {
        //given && when
        String messageProperties = "PROPERTIES-TEST";
        //then
        assertEquals(messageProperties, configurationProjectProperties.getProperties());
    }

    @Test
    void getDefaultRecipients() {
        //given && when && then
        assertEquals(configurationProjectProperties.getDefaultRecipients().get(0),
                "admin@mail.com");
        assertEquals(configurationProjectProperties.getDefaultRecipients().get(1),
                "owner@mail.com");
    }

    @Test
    void getAdditionalHeaders() {
        //given && when
        Set<String> set = configurationProjectProperties.getAdditionalHeaders().keySet();
        Map<String, String> map = configurationProjectProperties.getAdditionalHeaders();
        //then
        assertEquals(set.toString(), "[redelivery, secure]");
        assertEquals(map.size(), 2);
        assertEquals(map.get("redelivery"), "true");
        assertEquals(map.get("secure"), "true");
    }

    @Test
    void getCredentials() {
        //given && when
        Credentials credentials = configurationProjectProperties.getCredentials();

        //then
        assertEquals(credentials.getUsername(), "john");
        assertEquals(credentials.getPassword(), "password");
        assertEquals(credentials.getAuthMethod(), "SHA1");
    }

}
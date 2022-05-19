package com.itrex.bootcamp.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
class UserDetailsTest {

    @Autowired
    private JacksonTester<UserDetails> json;

    @Test
    public void testSerialize() throws Exception {

        UserDetails userDetails = new UserDetails(
                1L,
                "Duke",
                "Java",
                LocalDate.of(1995, 1, 1),
                true);

        JsonContent<UserDetails> result = this.json.write(userDetails);

        assertThat(result).hasJsonPathStringValue("$.firstname");
        assertThat(result).extractingJsonPathStringValue("$.firstname").isEqualTo("Duke");
        assertThat(result).extractingJsonPathStringValue("$.lastname").isEqualTo("Java");
        assertThat(result).extractingJsonPathStringValue("$.dateofbirth").isEqualTo("01.01.1995");
        assertThat(result).doesNotHaveJsonPath("$.enabled");
    }

    @Test
    public void testDeserialize() throws Exception {

        String jsonContent = "{\"firstname\":\"Mike\", \"lastname\": \"Meyer\"," +
                " \"dateofbirth\":\"15.05.1990\"," +
                " \"id\": 42, \"enabled\": true}";

        UserDetails result = this.json.parse(jsonContent).getObject();

        assertThat(result.getFirstName()).isEqualTo("Mike");
        assertThat(result.getLastName()).isEqualTo("Meyer");
        assertThat(result.getDateOfBirth()).isEqualTo(LocalDate.of(1990, 05, 15));
        assertThat(result.getId()).isEqualTo(42L);
        assertThat(result.isEnabled()).isEqualTo(true);
    }

    @Test
    public void testSerialize_second() throws Exception {

        UserDetails userDetails = new UserDetails(
                1L,
                "Duke",
                "Java",
                LocalDate.of(1995, 1, 1),
                true);

        JsonContent<UserDetails> result = this.json.write(userDetails);
        System.out.println(result);
        //result - JsonContent {"id":1,"firstname":"Duke","lastname":"Java","dateofbirth":"01.01.1995"}
        // created from com.itrex.nativecloud.model.UserDetails
        assertThat(result).extractingJsonPathStringValue("$.dateofbirth")
                .contains("01.01.1995");
        assertThat(result).hasJsonPathNumberValue("$.id", 1);
        assertThat(result).extractingJsonPathNumberValue("$.id", 1, Long.class);

        assertThat(result).hasJsonPathStringValue("$.firstname", "Duke");
        assertThat(result).hasJsonPathStringValue("$.lastname", "Java");
    }

}
package com.itrex.bootcamp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.LowerCaseStrategy.class)
@NoArgsConstructor
@AllArgsConstructor
public class UserDetails {

    private Long id;
    private String firstName;
    private String lastName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private LocalDate dateOfBirth;

    //JsonProperty.Access.WRITE_ONLY tells Jackson not to include
    // the value while serializing the object
    // but expect it when deserializing a JSON string back to this
    // object.
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private boolean enabled;
}

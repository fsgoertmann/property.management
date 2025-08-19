package com.mycompany.propery.management.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private Long id;
    private String userName;
    @NotNull(message = "Email must be informed")
    @NotEmpty(message = "Email cannot be empty")
    private String userEmail;
    @NotNull(message = "Password must be informed")
    @NotEmpty(message = "Password cannot be empty")
    @Size(min = 8, message = "Password must have more than 8 characters")
    private String password;
    private String phone;
}

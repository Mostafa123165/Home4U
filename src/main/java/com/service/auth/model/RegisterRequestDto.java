package com.service.auth.model;

import com.service.userManagement.dto.UserTypeDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RegisterRequestDto {

    @NotBlank(message = "first name cannot be blank")
    private String firstName;

    @NotBlank(message = "first name cannot be blank")
    private String lastName;

    private String email;
    private String phone;
    private String password;

    @NotNull(message = "user type cannot be blank")
    private UserTypeDto userType;
}

package com.service.auth.model;

import com.service.userManagement.dto.UserTypeDto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
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

    @Email(message = "Please provide a valid email address (e.g., user@example.com).")
    private String email;
    private String phone;

    @Min(value = 8, message = "Password must be at least 8 characters.")
    private String password;

    @NotNull(message = "user type cannot be blank")
    private UserTypeDto userType;
}

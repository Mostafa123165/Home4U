package com.service.auth.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LoginRequestDto {

    @NotEmpty(message = "email or phone is required")
    private String emailOrPhone;

    @NotEmpty(message = "password is required")
    private String password;
}

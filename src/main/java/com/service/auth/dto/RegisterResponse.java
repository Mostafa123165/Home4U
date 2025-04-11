package com.service.auth.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class RegisterResponse {
    private Long id;
    private String message;

    public RegisterResponse(String message) {
        this.message = message;
    }
}

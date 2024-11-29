package com.service.auth.controller;

import com.service.auth.model.LoginRequestDto;
import com.service.auth.model.LoginResponseDto;
import com.service.auth.model.RegisterRequestDto;
import com.service.auth.service.AuthService;
import com.service.base.model.SuccessResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequestDto registerRequest) {
        return ResponseEntity.ok(new SuccessResponse<>(authService.register(registerRequest)));
    }



    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequestDto authRequest  ) {
        return ResponseEntity.ok(new SuccessResponse<>(authService.login(authRequest)));
    }

}

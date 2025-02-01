package com.service.auth.controller;

import com.service.auth.model.LoginRequestDto;
import com.service.auth.model.RefreshTokenDto;
import com.service.auth.model.UserRegisterDto;
import com.service.auth.service.AuthService;
import com.service.base.model.SuccessResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody UserRegisterDto registerRequest) {
        return ResponseEntity.ok(new SuccessResponse<>(authService.register(registerRequest)));
    }

    @PostMapping(path = "/engineering-office-register",consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<?> engineeringOfficeRegister(
            @RequestPart("commercialRegister") MultipartFile commercialRegister,
            @RequestPart("personalCard") MultipartFile personalCard,
            @RequestPart("taxCard") MultipartFile taxCard,
            @RequestPart(value = "cover",required = false) MultipartFile cover,
            @RequestPart UserRegisterDto registerRequest) {
        return ResponseEntity.ok(new SuccessResponse<>(authService.engineeringOfficeRegister(commercialRegister,personalCard,taxCard,cover,registerRequest)));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequestDto authRequest  ) {
        return ResponseEntity.ok(new SuccessResponse<>(authService.login(authRequest)));
    }

    @PostMapping("/send-otp")
    public ResponseEntity<?> sendOtp(@RequestParam String email) {
        return ResponseEntity.ok(new SuccessResponse<>(authService.sendOpt(email)));
    }

    @PostMapping("/activate-the-account")
    public ResponseEntity<?> activateTheAccount(@RequestParam String otp, @RequestParam String email) {
        return ResponseEntity.ok(new SuccessResponse<>(authService.activateTheAccount(otp,email)));
    }

    @PutMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestParam String email,@RequestParam String newPassword) {
        return ResponseEntity.ok(new SuccessResponse<>(authService.resetPassword(email,newPassword)));
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<?> refreshToken(@RequestBody RefreshTokenDto request) {
        return ResponseEntity.ok(new SuccessResponse<>(authService.refreshToken(request)));
    }

}

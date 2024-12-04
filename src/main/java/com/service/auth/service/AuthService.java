package com.service.auth.service;


import com.service.auth.jwt.JwtGenerator;
import com.service.auth.jwt.TokenUtils;
import com.service.auth.model.*;
import com.service.base.Constant;
import com.service.common.service.MessageSourceService;
import com.service.common.service.SendOptService;
import com.service.error.BadRequestException;
import com.service.userManagement.mapper.UserMapper;
import com.service.userManagement.model.User;
import com.service.userManagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserService userService;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final MessageSourceService messageSourceService;
    private final JwtGenerator jetGenerator;
    private final AuthenticationManager authenticationManager;
    private final SendOptService sendOptService;
    private final TokenUtils tokenUtils;
    private final JwtGenerator jwtGenerator;

    @Transactional
    public String register(RegisterRequestDto registerRequest) {

        validateRegisterRequest(registerRequest.getEmail(), registerRequest.getPhone());

        registerRequest.setPassword(hashingPassword(registerRequest.getPassword()));
        User user = userMapper.unMapRegister(registerRequest);

        if(user.getUserType().getCode().equals(Constant.UserTypeEnum.GENERAL_USER.name())) {
             userService.insert(user);
        }
        else if(registerRequest.getUserType().getCode().equals(Constant.UserTypeEnum.ENGINEER.name())) {
        }
        else{
        }

        sendOptService.sendOtp(user);

        return messageSourceService.getMessage("success.user.registered");
    }

    private void validateRegisterRequest(String email,String phone) {
        if(email==null && phone==null) {
            throw new BadRequestException("Either email or phone must be provided. Please provide at least one contact method.");
        }
        else if(email != null && userService.getByEmail(email).isPresent()) {
           throw new BadRequestException(messageSourceService.getMessage("validation.email.in_use"));
        }
        else if(phone != null && userService.getByPhone(phone).isPresent()) {
           throw new BadRequestException(messageSourceService.getMessage("validation.phone.in_use"));
        }
    }

    private String hashingPassword(String password) {
        return passwordEncoder.encode(password);
    }

    public LoginResponseDto login(LoginRequestDto request) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(request.getEmailOrPhone(), request.getPassword());

        Authentication authenticated = authenticationManager.authenticate(authentication);

        User user = (User)authenticated.getPrincipal();

        checkUserIsEnabled(user);

        String token = jetGenerator.generateToken(user.getId(),false);
        String refreshToken = jetGenerator.generateToken(user.getId(),true);

        return LoginResponseDto
                .builder()
                .token(token)
                .refreshToken(refreshToken)
                .user(userMapper.map(user))
                .build();
    }

    private void checkUserIsEnabled(User user) {
        if(!user.isEnabled()) {
            throw new BadRequestException(messageSourceService.getMessage("validation.user.enabled"));
        }
    }

    @Transactional
    public String activateTheAccount(String otp,String email) {
        User user = userService.findByEmail(email);
        validateOtp(otp,user);
        user.setEnabled(true);
        return messageSourceService.getMessage("success.user.enabled");
    }

    private void validateOtp(String otp,User user) {
        if(!user.getOtp().equals(otp)) {
            throw new BadRequestException(messageSourceService.getMessage("invalid.otp"));
        }
    }

    public String sendOpt(String email) {
        User user = userService.findByEmail(email);
        sendOptService.sendOtp(user);
        return messageSourceService.getMessage("otp.sent.success");
    }

    @Transactional
    public String resetPassword(String email, String newPassword) {
        User user = userService.findByEmail(email);
        user.setPassword(passwordEncoder.encode(newPassword));
        return messageSourceService.getMessage("reset.password.success");
    }

    public AccessTokenDto refreshToken(RefreshTokenDto request) {
        Long id = tokenUtils.validateToken(request.getRefreshToken());
        if(id != null && id > 0) {
           String token = jetGenerator.generateToken(id,false);
           return new AccessTokenDto(token);
        }
        throw new BadRequestException("Invalid refresh token");
    }
}

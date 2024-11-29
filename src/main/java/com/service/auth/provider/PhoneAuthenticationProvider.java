package com.service.auth.provider;

import com.service.userManagement.model.User;
import com.service.userManagement.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@AllArgsConstructor
public class PhoneAuthenticationProvider implements AuthenticationProvider {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String phone = authentication.getName();
        String password = authentication.getCredentials().toString();

        Optional<User> user = userService.getByPhone(phone);

        if(user.isPresent() && passwordEncoder.matches(password, user.get().getPassword())) {
            return new UsernamePasswordAuthenticationToken(user.get(), password , user.get().getAuthorities());
        }

        return new UsernamePasswordAuthenticationToken(null,null);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}

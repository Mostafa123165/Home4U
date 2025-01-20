package com.service.config;

import com.service.auth.jwt.JwtValidatorFilter;
import com.service.auth.provider.EmailAuthenticationProvider;
import com.service.auth.provider.PhoneAuthenticationProvider;
import com.service.common.service.MessageSourceService;
import com.service.error.CustomAuthenticationEntryPoint;
import com.service.userManagement.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;

@Configuration
public class SecurityConfig {


    private final List<String> ALLOWED_ORIGIN = List.of(
            "http://localhost:4200",
            "http://localhost:5173",
            "https://starter-final-project.vercel.app"
    );

    private final List<String> ALLOWED_METHOD = List.of(
            "GET", "POST", "PUT", "DELETE","OPTIONS"
    );

    private final String[] PERMIT_URL = {
            "api/v1/auth/**",
            "api/v1/user-types/**",
            "api/v1/governorates/**",
            "api/v1/cities/governorate/**",
            "api/v1/engineer-types/**",
            "api/v1/engineer-services/service/**",
            "api/v1/technical-worker-types/**",
            "api/v1/technical-worker-services/service/**",
            "swagger-ui/**",
            "v3/api-docs/**",
            "favicon.ico/**",
            "api/v1/file/download/**",
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(AbstractHttpConfigurer::disable)
                .cors(scc -> scc.configurationSource(request -> corsConfiguration()))
                .formLogin(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(request -> request
                        .requestMatchers(PERMIT_URL).permitAll()
                        .anyRequest().authenticated()
                )
                .addFilterBefore(jwtValidatorFilter(), BasicAuthenticationFilter.class)
                .exceptionHandling(config -> config.authenticationEntryPoint(new CustomAuthenticationEntryPoint()));

        return http.build();
    }

    CorsConfiguration corsConfiguration() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.setAllowedOrigins(ALLOWED_ORIGIN);
        config.setAllowedMethods(ALLOWED_METHOD);
        config.setAllowedHeaders(List.of("*"));
        return config;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(UserService userService, PasswordEncoder passwordEncoder, MessageSourceService messageSourceService) {
        return new ProviderManager(
                new PhoneAuthenticationProvider(userService,passwordEncoder,messageSourceService),
                new EmailAuthenticationProvider(userService,passwordEncoder,messageSourceService)
        );
    }

    @Bean
    public JwtValidatorFilter jwtValidatorFilter() {
        return new JwtValidatorFilter();
    }

}

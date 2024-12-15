package com.service.auth.jwt;

import com.service.error.BadRequestException;
import com.service.userManagement.model.User;
import com.service.userManagement.service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Log4j2
public class JwtValidatorFilter extends OncePerRequestFilter {

   @Autowired
   private TokenUtils tokenUtils;

   @Autowired
   private UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String token = extractTokenFromRequest(request);
        if (token == null) {
            throw new BadRequestException("Not valid token");
        }

        Long userId = tokenUtils.validateToken(token,response);

        User user = userService.findById(userId);

        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities()));

        filterChain.doFilter(request, response);
    }

    private String extractTokenFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if(bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        System.out.println("tes -> " + request.getRequestURI());
        return   request.getRequestURI().startsWith("/api/v1/auth")
                | request.getRequestURI().startsWith("/api/v1/user-types")
                | request.getRequestURI().startsWith("/api/v1/cities/governorate")
                | request.getRequestURI().startsWith("/api/v1/governorates")
                | request.getRequestURI().startsWith("/api/v1/engineer-types")
                | request.getRequestURI().startsWith("/api/v1/engineer-services/service")
                | request.getRequestURI().startsWith("/api/v1/technical-worker-types")
                | request.getRequestURI().startsWith("/api/v1/technical-worker-services/service")
                | request.getRequestURI().startsWith("/swagger-ui")
                | request.getRequestURI().startsWith("/favicon.ico")
                | request.getRequestURI().startsWith("/v3/api-docs")
                | request.getRequestURI().startsWith("/api/v1/file/download");
    }
}

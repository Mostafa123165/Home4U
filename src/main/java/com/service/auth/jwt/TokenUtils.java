package com.service.auth.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;

@Component
public class TokenUtils {

    @Value("${home4u.secret.key}")
    private String secretKey;

    public Long validateToken(String token) {
        try {
             Claims claims =Jwts
                    .parser()
                    .verifyWith(getSecretKey())
                    .build()
                    .parseSignedClaims(token).getPayload();
            return Long.parseLong(claims.getSubject());
        }catch (ExpiredJwtException e){
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(null,null,null));
            throw new RuntimeException("Expired JWT token");
        }
    }

    private SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
    }
}

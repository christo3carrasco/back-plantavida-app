package com.plantavida.back.security;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {
    @Value("${app.jwt-secret}")
    private String jwtSecret;

    @Value("${app.jwt-expiration-milliseconds}")
    private int jwtExpirationInMs;

    public String genToken(Authentication authentication) {
        String username = authentication.getName();
        Date dateNow = new Date();
        Date dateExp = new Date(dateNow.getTime() + jwtExpirationInMs);
        String token = Jwts.builder().setSubject(username).setIssuedAt(new Date()).setExpiration(dateExp)
                .signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
        return token;
    }

    public String getUserFromJwt(String token) {
        Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

    public boolean valToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJwt(token);
            return true;
        } catch (SignatureException ex) {
            throw new AppException(HttpStatus.BAD_REQUEST, "Firma no valida");
        } catch (MalformedJwtException ex) {
            throw new AppException(HttpStatus.BAD_REQUEST, "Token no valido");
        } catch (ExpiredJwtException ex) {
            throw new AppException(HttpStatus.BAD_REQUEST, "Token caducado");
        } catch (UnsupportedJwtException ex) {
            throw new AppException(HttpStatus.BAD_REQUEST, "Token no compatible");
        } catch (IllegalArgumentException ex) {
            throw new AppException(HttpStatus.BAD_REQUEST, "Token sin datos");
        }
    }
}

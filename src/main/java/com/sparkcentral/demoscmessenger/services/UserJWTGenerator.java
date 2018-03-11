package com.sparkcentral.demoscmessenger.services;

import io.jsonwebtoken.Jwts;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import static io.jsonwebtoken.SignatureAlgorithm.HS256;
import static java.util.Base64.getEncoder;

@Service
public class UserJWTGenerator {

    private final Environment environment;

    public UserJWTGenerator(Environment environment) {
        this.environment = environment;
    }

    public String createUserJwt(String userId) {
        return Jwts.builder()
                .claim("scope", "appUser")
                .claim("userId", userId)
                .setHeaderParam("kid", environment.getRequiredProperty("SECRET_ID"))
                .setHeaderParam("typ", "JWT")
                .signWith(HS256, base64Encoded(environment.getRequiredProperty("SECRET_KEY")))
                .compact();
    }

    private String base64Encoded(String value) {
        return new String(getEncoder().encode(value.getBytes()));
    }
}

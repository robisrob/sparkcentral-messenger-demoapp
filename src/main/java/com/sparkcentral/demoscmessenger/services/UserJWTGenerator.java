package com.sparkcentral.demoscmessenger.services;

import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import static io.jsonwebtoken.SignatureAlgorithm.HS256;
import static org.apache.tomcat.util.codec.binary.Base64.encodeBase64;

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
                .setHeaderParam("kid", environment.getProperty("secretId"))
                .setHeaderParam("typ", "JWT")
                .signWith(HS256, base64Encoded(environment.getProperty("secretKey")))
                .compact();
    }

    private String base64Encoded(String value) {
        return new String(encodeBase64(value.getBytes()));
    }
}

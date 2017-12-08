package com.sparkcentral.jwtgenerator;

import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static io.jsonwebtoken.SignatureAlgorithm.HS256;
import static org.apache.tomcat.util.codec.binary.Base64.encodeBase64;

@Service
class UserJWTGenerator {

    private final String secretId;
    private final String secretKey;

    UserJWTGenerator(@Value("${SECRET_ID}")String secretId, @Value("${SECRET_KEY}")String secretKey) {
        this.secretId = secretId;
        this.secretKey = secretKey;
    }

    public String createUserJwt(String userId) {
        return Jwts.builder()
                .claim("scope", "appUser")
                .claim("userId", userId)
                .setHeaderParam("kid", secretId)
                .setHeaderParam("typ", "JWT")
                .signWith(HS256, base64Encoded(secretKey))
                .compact();
    }

    private String base64Encoded(String value) {
        return new String(encodeBase64(value.getBytes()));
    }
}

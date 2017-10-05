package com.sparkcentral.smooch.jwtgenerator;

import com.amazonaws.util.Base64;
import io.jsonwebtoken.Jwts;

import static io.jsonwebtoken.SignatureAlgorithm.HS256;

class UserJWTGenerator {

    static String createUserJwt(String userId, String secretId, String secretKey) {
        return Jwts.builder()
                .claim("scope", "appUser")
                .claim("userId", userId)
                .setHeaderParam("kid", secretId)
                .setHeaderParam("typ", "JWT")
                .signWith(HS256, base64Encoded(secretKey))
                .compact();
    }


    private static String base64Encoded(String value) {
        return new String(Base64.encode(value.getBytes()));
    }
}

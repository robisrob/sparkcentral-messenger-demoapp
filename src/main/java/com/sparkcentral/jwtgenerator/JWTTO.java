package com.sparkcentral.jwtgenerator;

import java.util.Objects;

public class JWTTO {

    private final String jsonwebtoken;

    public JWTTO(String jsonwebtoken) {
        this.jsonwebtoken = jsonwebtoken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JWTTO jwtto = (JWTTO) o;
        return Objects.equals(jsonwebtoken, jwtto.jsonwebtoken);
    }

    public String getJsonwebtoken() {
        return jsonwebtoken;
    }

    @Override
    public int hashCode() {
        return Objects.hash(jsonwebtoken);
    }

    @Override
    public String toString() {
        return "JWTTO{" +
                "jsonwebtoken='" + jsonwebtoken + '\'' +
                '}';
    }
}

package com.sparkcentral.smooch.jwtgenerator;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class UserJWTGeneratorTest {

    private static final String secretId = "app_51caqd235b46f1003a6de653";
    private static final String secretKey = "zWtoLXbr25od8MwFTaCgdKel";

    @Test
    public void testCreateJWT() {
        Assertions.assertThat(new UserJWTGenerator().createUserJwt("rob.s@sparkcentral.com", secretId, secretKey))
                .isEqualTo("eyJraWQiOiJhcHBfNTFjYXFkMjM1YjQ2ZjEwMDNhNmRlNjUzIiwidHlwIjoiSldUIiwiYWxnIjoiSFMyNTYifQ.eyJzY29wZSI6ImFwcFVzZXIiLCJ1c2VySWQiOiJyb2Iuc0BzcGFya2NlbnRyYWwuY29tIn0.uowfVrT8CgeurpRiwTCa7CMpyfze3LShpT0CKOtSOkg");
    }
}
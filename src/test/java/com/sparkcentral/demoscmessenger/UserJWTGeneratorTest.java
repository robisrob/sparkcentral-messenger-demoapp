package com.sparkcentral.demoscmessenger;

import com.sparkcentral.demoscmessenger.services.UserJWTGenerator;
import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.core.env.Environment;
import org.springframework.core.env.StandardEnvironment;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class UserJWTGeneratorTest {

    private static final String secretId = "app_51caqd235b46f1003a6de653";
    private static final String secretKey = "zWtoLXbr25od8MwFTaCgdKel";

    @Rule public MockitoRule mockito = MockitoJUnit.rule();

    @Mock private Environment environment;

    @InjectMocks private UserJWTGenerator userJWTGenerator;

    @Test
    public void testCreateJWT() {
        //GIVEN
        when(environment.getRequiredProperty("SECRET_ID")).thenReturn(secretId);
        when(environment.getRequiredProperty("SECRET_KEY")).thenReturn(secretKey);

        //WHEN
        String actual = userJWTGenerator.createUserJwt("rob.s@sparkcentral.com");

        //THEN
        assertThat(actual)
                .isEqualTo("eyJraWQiOiJhcHBfNTFjYXFkMjM1YjQ2ZjEwMDNhNmRlNjUzIiwidHlwIjoiSldUIiwiYWxnIjoiSFMyNTYifQ.eyJzY29wZSI6ImFwcFVzZXIiLCJ1c2VySWQiOiJyb2Iuc0BzcGFya2NlbnRyYWwuY29tIn0.uowfVrT8CgeurpRiwTCa7CMpyfze3LShpT0CKOtSOkg");
    }
}
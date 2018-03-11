package com.sparkcentral.demoscmessenger;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;


public class UserJWTControllerIntegrationTest extends AbstractIntegrationTest{

    @Autowired
    private WebTestClient webClient;

    @Test
    public void testGetJWTToken() {
        webClient
                .get()
                .uri("/rest/jwt?userId=rob.s@sparkcentral.com")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(String.class)
                .isEqualTo("eyJraWQiOiJhcHBfNTFjYXFkMjM1YjQ2ZjEwMDNhNmRlNjUzIiwidHlwIjoiSldUIiwiYWxnIjoiSFMyNTYifQ.eyJzY29wZSI6ImFwcFVzZXIiLCJ1c2VySWQiOiJyb2Iuc0BzcGFya2NlbnRyYWwuY29tIn0.uowfVrT8CgeurpRiwTCa7CMpyfze3LShpT0CKOtSOkg");
    }
}

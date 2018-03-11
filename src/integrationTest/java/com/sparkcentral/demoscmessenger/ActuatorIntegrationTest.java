package com.sparkcentral.demoscmessenger;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

public class ActuatorIntegrationTest extends AbstractIntegrationTest{

    @Autowired
    private WebTestClient webClient;

    @Test
    public void testGetInfo() {
        webClient
                .get()
                .uri("/info")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(String.class)
                .isEqualTo("{\"app\":{\"version\":\"local\"}}");
    }

    @Test
    public void testGetHealth() {
        webClient
                .get()
                .uri("/health")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(String.class)
                .isEqualTo("{\"status\":\"UP\"}");
    }
}

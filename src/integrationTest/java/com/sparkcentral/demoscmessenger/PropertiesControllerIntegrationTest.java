package com.sparkcentral.demoscmessenger;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

public class PropertiesControllerIntegrationTest extends AbstractIntegrationTest{

    @Autowired
    private WebTestClient webClient;

    @Test
    public void testGetAppId() {
        webClient
                .get()
                .uri("/rest/properties/appId")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(String.class)
                .isEqualTo("anAppId");
    }
}

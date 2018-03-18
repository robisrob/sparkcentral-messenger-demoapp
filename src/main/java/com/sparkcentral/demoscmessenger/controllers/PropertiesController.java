package com.sparkcentral.demoscmessenger.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import static reactor.core.publisher.Mono.just;

@RestController
@RequestMapping("rest/properties")
public class PropertiesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesController.class);
    private final Environment environment;

    public PropertiesController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("appId")
    public String getAppId() {
        LOGGER.debug("Calling getAppId");
        return environment.getRequiredProperty("APP_ID");
    }
}

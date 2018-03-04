package com.sparkcentral.demoscmessenger.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest/properties")
public class PropertiesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesController.class);
    private final String appId;

    public PropertiesController(@Value("${APP_ID}")String appId) {
        this.appId = appId;
    }

    @GetMapping("appId")
    public String getAppId() {
        LOGGER.info("Calling getAppId");
        return appId;
    }
}

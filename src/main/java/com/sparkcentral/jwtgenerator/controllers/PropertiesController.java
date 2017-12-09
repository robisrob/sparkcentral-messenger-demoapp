package com.sparkcentral.jwtgenerator.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("properties")
public class PropertiesController {

    private final String appId;

    public PropertiesController(@Value("${APP_ID}")String appId) {
        this.appId = appId;
    }

    @GetMapping("appId")
    public String getAppId() {
        return appId;
    }
}

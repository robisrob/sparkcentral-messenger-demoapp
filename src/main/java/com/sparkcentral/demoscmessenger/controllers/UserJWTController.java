package com.sparkcentral.demoscmessenger.controllers;

import com.sparkcentral.demoscmessenger.services.UserJWTGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("rest/jwt")
public class UserJWTController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserJWTController.class);
    private final UserJWTGenerator userJWTGenerator;

    public UserJWTController(UserJWTGenerator userJWTGenerator) {
        this.userJWTGenerator = userJWTGenerator;
    }

    @GetMapping
    public String getJWTToken(@RequestParam(value="userId") String userId) {
        LOGGER.debug("getJWTToken for {}", userId);
        return userJWTGenerator.createUserJwt(userId);
    }

}

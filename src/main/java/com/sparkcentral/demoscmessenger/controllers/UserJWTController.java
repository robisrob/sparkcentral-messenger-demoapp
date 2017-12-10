package com.sparkcentral.demoscmessenger.controllers;

import com.sparkcentral.demoscmessenger.services.UserJWTGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("rest/jwt")
public class UserJWTController {

    private final UserJWTGenerator userJWTGenerator;

    public UserJWTController(UserJWTGenerator userJWTGenerator) {
        this.userJWTGenerator = userJWTGenerator;
    }

    @GetMapping
    public String getJWTToken(@PathParam(value="userId") String userId) {
        return userJWTGenerator.createUserJwt(userId);
    }

}

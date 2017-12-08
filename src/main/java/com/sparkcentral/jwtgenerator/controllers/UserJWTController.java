package com.sparkcentral.jwtgenerator.controllers;

import com.sparkcentral.jwtgenerator.tos.JWTTO;
import com.sparkcentral.jwtgenerator.services.UserJWTGenerator;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("jwt")
public class UserJWTController {

    private final UserJWTGenerator userJWTGenerator;

    public UserJWTController(UserJWTGenerator userJWTGenerator) {
        this.userJWTGenerator = userJWTGenerator;
    }

    @GetMapping()
    public JWTTO getJWTToken(@PathParam(value="userId") String userId) {
        return userJWTGenerator.createUserJwt(userId);
    }
}

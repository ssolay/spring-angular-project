package com.spring.example.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.spring.example.web.security.exceptions.IllegalAuthorizationTokenException;
import com.spring.example.web.security.services.TokenAuthenticationService;

@RestController
public class LoginStatusController {

    @Autowired
    private TokenAuthenticationService authenticationService;

    @GetMapping("/api/login/check")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void checkLoginStatus(@RequestHeader("Authorization") String authToken) {
        authenticationService.isAuthorized(authToken);
    }

    @ExceptionHandler(IllegalAuthorizationTokenException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public void handleIllegalAuthorizationToken() {}
}

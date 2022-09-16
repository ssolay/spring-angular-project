package com.spring.example.web.security.services;

import org.springframework.security.core.Authentication;

import com.spring.example.web.security.exceptions.IllegalAuthorizationTokenException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface TokenAuthenticationService {

    /**
     * Method to provide JWT into response header on success authorization.
     * @param response where to place header
     * @param username to pass into token
     */
    void addAuthentication(HttpServletResponse response, String username);

    /**
     * Method to check request for JWT in header.
     * @param request to check
     * @return ready authentication on success, either null
     */
    Authentication getAuthentication(HttpServletRequest request);

    /**
     * Checks token for validation.
     * @param token to check
     * @throws IllegalAuthorizationTokenException will be thrown if token expired or invalid for other reasons
     */
    void isAuthorized(String token) throws IllegalAuthorizationTokenException;
}

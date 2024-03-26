package com.widia.iwefollow.controller;

import com.widia.iwefollow.model.request.LoginRequest;
import com.widia.iwefollow.model.request.UserRequest;
import com.widia.iwefollow.services.users.AuthenticationService;
import com.widia.iwefollow.services.users.SaveUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private SaveUserService saveUserService;

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/v1/register")
    public ResponseEntity<String> saveNewUser(@RequestBody UserRequest userRequest) {
        try {
            saveUserService.saveUser(userRequest);
            log.info("User registered successfully: {}", userRequest.getUsername());
            return ResponseEntity.ok("User registered successfully");
        } catch (Exception e) {
            log.error("Error registering user: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error registering user");
        }
    }

    @PostMapping("/v1/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        try {
            boolean authenticated = authenticationService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());
            if (authenticated) {
                log.info("User logged in successfully: {}", loginRequest.getUsername());
                return ResponseEntity.ok("Login successful");
            } else {
                log.warn("Invalid credentials for user: {}", loginRequest.getUsername());
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
            }
        } catch (Exception e) {
            log.error("Error during login: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error during login");
        }
    }
}

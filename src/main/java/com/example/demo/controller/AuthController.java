package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.model.UserDTO;
import com.example.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private AuthService service;


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        return service.register(user);

    }
    @PostMapping("/validate")
    public Boolean validate(@RequestBody String token) {
        return service.validate(token);

    }
    @GetMapping("/user_info")
    public ResponseEntity<?> info(@RequestParam String token) {
        return service.getUser(token);

    }
    @PostMapping("/login")
    public Object login(@RequestBody User user) {

        return service.verify(user);
    }
}

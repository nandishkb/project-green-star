package com.outreach.greenstar.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/login")
public class LoginController {
    
    @GetMapping(path="", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> login() {
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

}

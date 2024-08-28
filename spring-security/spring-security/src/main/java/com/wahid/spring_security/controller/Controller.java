package com.wahid.spring_security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secure")
public class Controller {
    @GetMapping
    public String getWelcome()
    {
        return "<h1>Welcome to Spring Security</h1>";
    }

}

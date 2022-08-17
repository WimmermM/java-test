package com.example.usersapp.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController {

    @GetMapping(value = "/test")
    public void testEndpoint() {
        log.info("test endpoint was called");
    }
}

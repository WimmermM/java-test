package com.example.usersapp.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
@RequiredArgsConstructor
public class TestController {

    @GetMapping(value = "/test")
    public String testEndpoint() {
        String message = "test endpoint was called";
        log.info(message);
        return message;
    }
}

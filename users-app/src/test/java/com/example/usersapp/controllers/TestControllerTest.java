package com.example.usersapp.controllers;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TestControllerTest {

    private TestController testController;

    @BeforeEach
    void setup() {
        testController = new TestController();
    }

    @Test
    void testEndpoint() {
        Assertions.assertEquals("test endpoint was called", testController.testEndpoint());
    }

}

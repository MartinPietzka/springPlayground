package com.example.spring_playground.controller;

import com.example.spring_playground.service.GreetingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }


    @GetMapping("/hello/{name}")
    public String greet(@PathVariable String name) {
        return greetingService.greet(name);
    }

    @GetMapping("/helloToAll")
    public String greetAll() {
        return greetingService.greetAll();
    }
}

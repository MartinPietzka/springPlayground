package com.example.spring_playground.service;

import com.example.spring_playground.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class GreetingService {
    private final UserRepository userRepository;

    @Value("${app.greeting.prefix}")
    private String greetingPrefix;

    public GreetingService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public String greet(String name) {
        return greetingPrefix + ", " + name + "!";
    }

    public String greetAll() {
        return userRepository.findAll().stream()
                .map(name -> greetingPrefix + " " + name)
                .collect(Collectors.joining(". ")) + ".";
    }


}

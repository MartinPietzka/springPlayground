package com.example.spring_playground.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Profile("Liste2")
@Repository
public class UserRepositoryListe2 implements UserRepository {
    private final List<String> users = new ArrayList<>(List.of("John", "Bob", "Mike", "Jake"));


    @Override
    public List<String> findAll() {
        return users;
    }
}
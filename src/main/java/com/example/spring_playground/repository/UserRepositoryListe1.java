package com.example.spring_playground.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Profile("Liste1")
@Repository
public class UserRepositoryListe1 implements UserRepository {
    private final List<String> users = new ArrayList<>(List.of("Hans", "Peter", "Lisa", "Martin"));


    @Override
    public List<String> findAll() {
        return users;
    }
}


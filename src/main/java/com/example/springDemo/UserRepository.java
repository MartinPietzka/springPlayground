package com.example.springDemo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private final List<String> users = new ArrayList<>(List.of("Hans", "Peter", "Lisa", "Martin"));

    public List<String> findAll() {
        return users;
    }
}

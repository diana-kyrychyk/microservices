package com.learn.users.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final List<String> users = List.of("Maksym Pryimachenko", "Valeriy Gupalo", "Solomiya Solovei");

    @GetMapping()
    public List<String> getUsers() {
        return this.users;
    }

    @GetMapping("/{id}")
    public String userById(@PathVariable int id) {
        try {
            return users.get(id - 1);
        } catch (RuntimeException e) {
            return String.format("There is no user with ID '%s'", id);
        }
    }

}

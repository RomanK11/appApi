package com.api.laps.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.laps.models.User;
import com.api.laps.repos.UserRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "api/users", produces = "application/json")
public class UserController {
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping()
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    public boolean existsByField(String fieldValue1, String fieldValue2) {
        return userRepository.findByEmailAndPassword(fieldValue1, fieldValue2) != null;
    }

    @PostMapping(path = "/registr")
    public User create(@RequestBody User user) {
        return userRepository.save(user);
    }

}

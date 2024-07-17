package com.crea.storage.controller;

import com.crea.storage.model.User;
import com.crea.storage.repository.UserRepository;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    @GetMapping()
//    private List<User> getUsers() {
//
//    }

    @PostMapping
    private ResponseEntity<User> createUser(@RequestBody @Valid User user) {
        return ResponseEntity.ok(userRepository.save(user));
    }
}

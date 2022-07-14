package com.example.myanimelibrary.infrastructure.web.controller;

import com.example.myanimelibrary.domain.User;
import com.example.myanimelibrary.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.saveUser(user));
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{login}")
    public ResponseEntity<User> getUserByLogin(@PathVariable("login") String login) {
        return ResponseEntity.ok(userService.getUserByLogin(login));
    }
}

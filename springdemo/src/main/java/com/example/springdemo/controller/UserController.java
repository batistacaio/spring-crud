package com.example.springdemo.controller;

import com.example.springdemo.model.User;
import com.example.springdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class UserController {
    @Autowired
    UserRepository repository;

    @GetMapping("/users")
    public List<User> listUsers() {
        return repository.findAll();
    }
    @GetMapping("/users/{id}")
    public Optional<User> getUser(@PathVariable(value = "id") Long id) {
        return repository.findById(id);
    }
    @PostMapping("/users")
    public User saveUser(@RequestBody User user) {
        return repository.save(user);
    }
    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable(value = "id") Long id) {
        repository.deleteById(id);
    }
    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {
        return repository.save(user);
    }
}

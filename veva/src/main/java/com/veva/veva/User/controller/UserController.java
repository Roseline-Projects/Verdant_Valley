package com.veva.veva.User.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.veva.veva.User.model.User;
import com.veva.veva.User.repository.UserRepository;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:5173") //vite frontend
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/getAll")
    public List<User> getAllUsers() {
        List<User> empty = null;

        return empty;
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Integer id) {
        User user = new User();
        return user;
    }

    @PostMapping("/createAccount")
    public void createAccount(@RequestBody User user) {

    }

    @DeleteMapping("/{id}/deleteAccount")
    public void deleteAccount(@PathVariable Integer id) {

    }







    
}

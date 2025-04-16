package com.veva.veva.User.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.veva.veva.User.model.User;
import com.veva.veva.User.repository.IUserRepository;
import com.veva.veva.User.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:5173") //vite frontend
public class UserController {

    private final IUserRepository userRepository;
    private final UserService userService;

    public UserController(IUserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping("/getAll") //debugging 
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Integer id) {
        User user = new User();
        return user;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/createAccount")
    public void createAccount(@RequestBody String username, 
                                @RequestBody String email, 
                                @RequestBody String password, 
                                @RequestBody String origin) {
        userService.createUser(username, email, password, origin); //there may be a better way to do this
    }

    @PostMapping("/{id}/update")
    public void updateAccount(@RequestBody User user, @PathVariable int id) {
        userService.updateUser(user, id);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping("/{id}/deleteAccount")
    public void deleteAccount(@PathVariable Integer id) {
        userService.deleteUser(id);
    }
}

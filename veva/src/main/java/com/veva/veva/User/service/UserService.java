package com.veva.veva.User.service;

import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import com.veva.veva.User.model.Origin;
import com.veva.veva.User.model.User;
import com.veva.veva.User.repository.IUserRepository;
import com.veva.veva.User.util.UserNotFoundException;

@Service
public class UserService {
    private final IUserRepository userRepository;

    UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.getAll();
    }

    //using data coming in from frontend request, make a user
    public boolean createUser(String username, String email, String password, String origin) {
        //needs input validation
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setUsername(username);
        user.setOrigin(Origin.toOrigin(origin));

        return userRepository.save(user);//returns true if successful
    }

    public boolean updateUser(User user, int userId) {
        boolean success = userRepository.updateById(user, userId);
        if(success == false) { //repeated code - see if there's a better way to do this
            throw new UserNotFoundException(userId);
        }
        return success;
    }

    public boolean deleteUser(int userId) {
        boolean success = userRepository.deleteById(userId);
        if(success == false) {
            throw new UserNotFoundException(userId);
        }
        return success;
    }
}

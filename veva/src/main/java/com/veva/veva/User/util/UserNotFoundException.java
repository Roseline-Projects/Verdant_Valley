package com.veva.veva.User.util;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(int userId) {
        super("Could not find user " + userId);
    }
    
}

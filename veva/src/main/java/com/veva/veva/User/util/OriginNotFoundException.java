package com.veva.veva.User.util;

public class OriginNotFoundException extends IllegalArgumentException {
    OriginNotFoundException(String s) {
        super("Origin " + s + " Not Found.");
    }
}

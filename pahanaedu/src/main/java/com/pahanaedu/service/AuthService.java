package com.pahanaedu.service;

import com.pahanaedu.model.User;

public class AuthService {

    // Simple hardcoded authentication for demo purposes
    public boolean login(String username, String password) {
        // In real app, retrieve user from database
        return "admin".equals(username) && "admin123".equals(password);
    }

    public boolean register(User user) {
        // Add registration logic here if needed
        return true;
    }
}

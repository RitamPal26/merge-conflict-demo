package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {
    private Map<String, User> users = new HashMap<>();
    
    public void addUser(User user) {
        System.out.println("Adding user: " + user.getId());
        
        // Add validation logic
        if (user.getId() == null || user.getId().isEmpty()) {
            throw new IllegalArgumentException("User ID cannot be empty");
        }
        if (user.getName() == null || user.getName().isEmpty()) {
            throw new IllegalArgumentException("User name cannot be empty");
        }
        if (user.getEmail() == null || !user.getEmail().contains("@")) {
            throw new IllegalArgumentException("Invalid email format");
        }
        
        users.put(user.getId(), user);
        System.out.println("User added successfully");
    }
    
    public User getUserById(String id) {
        System.out.println("Fetching user with ID: " + id);
        return users.get(id);
    }
    
    public List<User> getAllUsers() {
        System.out.println("Fetching all users");
        return new ArrayList<>(users.values());
    }
    
    public void updateUser(User user) {
        System.out.println("Updating user: " + user.getId());
        
        // Add validation logic
        if (user.getId() == null || user.getId().isEmpty()) {
            throw new IllegalArgumentException("User ID cannot be empty");
        }
        if (!users.containsKey(user.getId())) {
            System.out.println("User not found for update");
            throw new IllegalArgumentException("User not found");
        }
        if (user.getName() == null || user.getName().isEmpty()) {
            throw new IllegalArgumentException("User name cannot be empty");
        }
        if (user.getEmail() == null || !user.getEmail().contains("@")) {
            throw new IllegalArgumentException("Invalid email format");
        }
        
        users.put(user.getId(), user);
        System.out.println("User updated successfully");
    }
    
    public void deleteUser(String id) {
        System.out.println("Deleting user: " + id);
        users.remove(id);
        System.out.println("User deleted successfully");
    }
}
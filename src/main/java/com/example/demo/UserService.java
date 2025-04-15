package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {
    private Map<String, User> users = new HashMap<>();
    
    public void addUser(User user) {
        System.out.println("Adding user: " + user.getId());
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
        if (users.containsKey(user.getId())) {
            users.put(user.getId(), user);
            System.out.println("User updated successfully");
        } else {
            System.out.println("User not found for update");
        }
    }
    
    public void deleteUser(String id) {
        System.out.println("Deleting user: " + id);
        users.remove(id);
        System.out.println("User deleted successfully");
    }
}
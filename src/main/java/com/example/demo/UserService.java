package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {
    private Map<String, User> users = new HashMap<>();
    
    public void addUser(User user) {
        users.put(user.getId(), user);
    }
    
    public User getUserById(String id) {
        return users.get(id);
    }
    
    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }
    
    public void updateUser(User user) {
        if (users.containsKey(user.getId())) {
            users.put(user.getId(), user);
        }
    }
    
    public void deleteUser(String id) {
        users.remove(id);
    }
}
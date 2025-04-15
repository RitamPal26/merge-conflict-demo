package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class UserServiceTest {
    
    private UserService userService;
    
    @BeforeEach
    public void setUp() {
        userService = new UserService();
    }
    
    @Test
    public void testAddUser() {
        User user = new User("1", "John Doe", "john@example.com");
        userService.addUser(user);
        
        User retrievedUser = userService.getUserById("1");
        assertEquals("John Doe", retrievedUser.getName());
        assertEquals("john@example.com", retrievedUser.getEmail());
    }
    
    @Test
    public void testGetAllUsers() {
        User user1 = new User("1", "John Doe", "john@example.com");
        User user2 = new User("2", "Jane Smith", "jane@example.com");
        
        userService.addUser(user1);
        userService.addUser(user2);
        
        List<User> allUsers = userService.getAllUsers();
        assertEquals(2, allUsers.size());
        assertTrue(allUsers.stream().anyMatch(u -> u.getId().equals("1")));
        assertTrue(allUsers.stream().anyMatch(u -> u.getId().equals("2")));
    }
    
    @Test
    public void testUpdateUser() {
        User user = new User("1", "John Doe", "john@example.com");
        userService.addUser(user);
        
        User updatedUser = new User("1", "John Updated", "updated@example.com");
        userService.updateUser(updatedUser);
        
        User retrievedUser = userService.getUserById("1");
        assertEquals("John Updated", retrievedUser.getName());
        assertEquals("updated@example.com", retrievedUser.getEmail());
    }
    
    @Test
    public void testDeleteUser() {
        User user = new User("1", "John Doe", "john@example.com");
        userService.addUser(user);
        userService.deleteUser("1");
        
        assertNull(userService.getUserById("1"));
    }
    
    @Test
    public void testInvalidUserAddition() {
        // Test empty ID
        User userEmptyId = new User("", "John Doe", "john@example.com");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            userService.addUser(userEmptyId);
        });
        assertTrue(exception.getMessage().contains("ID cannot be empty"));
        
        // Test empty name
        User userEmptyName = new User("1", "", "john@example.com");
        exception = assertThrows(IllegalArgumentException.class, () -> {
            userService.addUser(userEmptyName);
        });
        assertTrue(exception.getMessage().contains("name cannot be empty"));
        
        // Test invalid email
        User userInvalidEmail = new User("1", "John Doe", "invalid-email");
        exception = assertThrows(IllegalArgumentException.class, () -> {
            userService.addUser(userInvalidEmail);
        });
        assertTrue(exception.getMessage().contains("Invalid email format"));
    }
    
    @Test
    public void testInvalidUserUpdate() {
        // Add a valid user first
        User user = new User("1", "John Doe", "john@example.com");
        userService.addUser(user);
        
        // Test update with non-existent ID
        User nonExistentUser = new User("999", "Non Existent", "nonexistent@example.com");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            userService.updateUser(nonExistentUser);
        });
        assertTrue(exception.getMessage().contains("User not found"));
        
        // Test update with empty name
        User userEmptyName = new User("1", "", "john@example.com");
        exception = assertThrows(IllegalArgumentException.class, () -> {
            userService.updateUser(userEmptyName);
        });
        assertTrue(exception.getMessage().contains("name cannot be empty"));
        
        // Test update with invalid email
        User userInvalidEmail = new User("1", "John Doe", "invalid-email");
        exception = assertThrows(IllegalArgumentException.class, () -> {
            userService.updateUser(userInvalidEmail);
        });
        assertTrue(exception.getMessage().contains("Invalid email format"));
    }
}
package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
}
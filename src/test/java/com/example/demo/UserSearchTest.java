package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class UserSearchTest {
    
    @Test
    public void testSearchUsersByName() {
        UserService userService = new UserService();
        
        // Add some users
        userService.addUser(new User("1", "John Doe", "john@example.com"));
        userService.addUser(new User("2", "Jane Smith", "jane@example.com"));
        userService.addUser(new User("3", "John Smith", "jsmith@example.com"));
        userService.addUser(new User("4", "Alice Johnson", "alice@example.com"));
        
        // Search for users with "John" in their name
        List<User> johnUsers = userService.searchUsersByName("John");
        assertEquals(2, johnUsers.size());
        assertTrue(johnUsers.stream().anyMatch(u -> u.getId().equals("1")));
        assertTrue(johnUsers.stream().anyMatch(u -> u.getId().equals("3")));
        
        // Search for users with "Smith" in their name
        List<User> smithUsers = userService.searchUsersByName("Smith");
        assertEquals(2, smithUsers.size());
        assertTrue(smithUsers.stream().anyMatch(u -> u.getId().equals("2")));
        assertTrue(smithUsers.stream().anyMatch(u -> u.getId().equals("3")));
        
        // Search for non-existent users
        List<User> nonExistentUsers = userService.searchUsersByName("XYZ");
        assertEquals(0, nonExistentUsers.size());
    }
}
package com.TheTask.TheTask;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class UserManagerTests {

    private UserManager userManager = new UserManager();
    private User testUser = new User("username");
    
    @Test
    public void testGetUserById_UserExists() {
        userManager.users.add(testUser);
        User result = userManager.getUserById(testUser.id);
        assertEquals(testUser, result);
    }
}

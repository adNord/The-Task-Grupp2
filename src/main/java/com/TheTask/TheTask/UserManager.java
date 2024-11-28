package com.TheTask.TheTask;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class UserManager {
    public List<User> users = new ArrayList<>();

    //currentUser är ett user objekt.
    private User currentUser;

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(UUID userId) {
        currentUser = getUserById(userId);
    }

    public User getUserById(UUID id){
        for (User user : users) {
            if (user.id.equals(id)) {
                return user;
            }
        }
        return null;
    }
}

package com.TheTask.TheTask;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    public List<User> users = new ArrayList<>();

    //currentUser är en 'user's id.
    private String currentUser;

    public String getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(String currentUser) {
        this.currentUser = currentUser;
    }

    
}

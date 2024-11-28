package com.TheTask.TheTask;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    String userName;
    UUID id;
    List<TodoList> userOwnedLists = new ArrayList<>();

    public User(String userName){
        this.userName = userName;
        this.id = UUID.randomUUID();
    }

    public void addList(TodoList todoList){
        return;
    }

    public String getUserName() {
        return userName;
    }

    public UUID getId() {
        return id;
    }
}

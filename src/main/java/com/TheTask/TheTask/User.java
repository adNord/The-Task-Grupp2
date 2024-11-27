package com.TheTask.TheTask;

import java.util.ArrayList;
import java.util.List;

public class User {
    String userName;
    String id;
    List<TodoList> userOwnedLists = new ArrayList<>();

    public User(String userName){
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void addList(TodoList todoList){
        return;
    }
}

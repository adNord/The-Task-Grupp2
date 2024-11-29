package com.TheTask.TheTask;

import java.util.ArrayList;
import java.util.List;

public class TodoList {
    String title;
    //String description;
    List<Task> tasks = new ArrayList<>();

    public TodoList(String title){
        this.title = title;
    }

    public void addTask(Task task){
        return;
    }

    public void removeTask(String title){
        return;
    }

    public String getTitle() {
        return title;
    }

    
}

package com.TheTask.TheTask;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TodoList {
    UUID listId;
    String title;
    //String description;
    List<Task> tasks = new ArrayList<>();

    public TodoList(String title){
        this.title = title;
        this.listId = UUID.randomUUID();
    }

    public void addTask(Task task){
        tasks.add(task);
        return;
    }

    public void removeTask(String title){
        return;
    }

    public String getTitle() {
        return title;
    }

    public List<Task> getTasks(){
        return tasks;
    }

    public void setTasks(List<Task> tasks){
        this.tasks = tasks;
    }

    public UUID getListId() {
        return listId;
    }

    
}

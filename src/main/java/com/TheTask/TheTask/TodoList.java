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
    }

    public void removeTask(UUID id){
        tasks.removeIf(task -> task.getTaskId().equals(id));
    }

    // Metod för att hitta en lista baserat på ID
    public Task getTaskById(UUID id) {
        for (Task task: tasks) {
            if (task.getTaskId().equals(id)) {
                return task;
            }
        }
        return null;
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

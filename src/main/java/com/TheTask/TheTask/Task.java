package com.TheTask.TheTask;

import java.time.LocalDate;

public class Task {
    private String title;
    private boolean completed;
    private LocalDate deadline;

    //constructor
    public Task(String title, LocalDate deadline){
        this.title = title;
        this.deadline = deadline;
        this.completed = false;
    }

    public boolean isOverdue(){
        return false;
    }

    public void markComplete(){
        return;
    }

    public boolean isCompleted() {
        return completed;
    }
}

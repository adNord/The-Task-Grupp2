package com.TheTask.TheTask;

import java.time.LocalDate;

public class Task {
    private String titleTask;
    private boolean completed;
    private LocalDate deadline;

    //constructor
    public Task(String titleTask, LocalDate deadline){
        this.titleTask = titleTask;
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

    public String getTitleTask() {
        return titleTask;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }
    
}

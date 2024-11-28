package com.TheTask.TheTask;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class TodoListTests {

    @Test
    public void addTaskTest(){
        TodoList todoList = new TodoList("title");
        assertEquals(0, todoList.tasks.size());

        Task task = new Task("title", LocalDate.now());
        todoList.addTask(task);
        assertEquals(1, todoList.tasks.size());
    }

    public void removeTaskTest(){
        TodoList todoList = new TodoList("title");
        Task task = new Task("title", LocalDate.now());
        todoList.addTask(task);
        assertEquals(1, todoList.tasks.size());

        todoList.removeTask("id");
        assertEquals(0, todoList.tasks.size());
    }
}

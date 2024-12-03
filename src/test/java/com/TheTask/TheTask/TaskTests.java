package com.TheTask.TheTask;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class TaskTests {

    @Test
    public void markCompleteTest(){
        Task task = new Task("title", LocalDate.now());
        assertFalse(task.isCompleted());
        task.markComplete();
        assertTrue(task.isCompleted());
    }

    @Test
    public void isOverdueTest(){
        LocalDate deadline = LocalDate.now().plusDays(1);
        Task task = new Task("title", deadline);
        assertFalse(task.isOverdue());
        deadline = LocalDate.now().minusDays(1);
        task.setDeadline(LocalDate.now().minusDays(1));
        assertTrue(task.isOverdue());
    }
}

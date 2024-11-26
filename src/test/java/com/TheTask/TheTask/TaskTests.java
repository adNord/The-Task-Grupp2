package com.TheTask.TheTask;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TaskTests {

    @Test
    public void markCompleteTest(){
        
    }

    @Test
    public void isOverdueTest(){
        Task task = new Task();
        assertTrue(task.isOverdue());
        assertFalse(task.isOverdue());
    }
}

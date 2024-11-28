package com.TheTask.TheTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoListController {
    @Autowired
    private UserManager userManager;

    @PostMapping("/addToDoList")
    public String addTodoList(@RequestParam String todoListTitle){
        User currentUser = userManager.getCurrentUser();
        TodoList newTodoList = new TodoList(todoListTitle);
        currentUser.addList(newTodoList);

        System.out.println("Antal listor för denna användare: " + currentUser.userOwnedLists.size());

        return "redirect:/";
    }

}

package com.TheTask.TheTask;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ch.qos.logback.core.model.Model;

@Controller
public class TaskController {

    @Autowired
    private UserManager userManager;

    @PostMapping("/newTask")
        public String newTask(@RequestParam String title, @RequestParam UUID listId, org.springframework.ui.Model model){
           // Hämta den aktuella användaren 
           User currentUser = userManager.getCurrentUser();

            //hitta listan med listId
            TodoList todoList = currentUser.getListById(listId);

            if (todoList != null) {
                // Skapa en ny task och lägg till den i listan
                Task newTask = new Task(title, null);
                todoList.addTask(newTask);
            }
            
            System.out.println(title);

            //lägg till aktuella användaren och deras listor i modellen
            model.addAttribute("currentUser", currentUser);
            model.addAttribute("userOwnedLists", currentUser.getUserOwnedLists());
            
           
            return "redirect:/";
        }
    
    
    

}

package com.TheTask.TheTask;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class TaskController {

    @Autowired
    private UserManager userManager;
    
    @PostMapping("/newTask")
        public String newTask(@RequestParam String titleTask, @RequestParam UUID listId, Model model){
            // Hämta den aktuella användaren 
            User currentUser = userManager.getCurrentUser();

            //hitta listan med listId
            TodoList todoList = currentUser.getListById(listId);

            if (todoList != null) {
                // Skapa en ny task och lägg till den i listan
                Task newTask = new Task(titleTask, null);
                todoList.addTask(newTask);
            }
            
            //lägg till aktuella användaren och deras listor i modellen
            model.addAttribute("currentUser", currentUser);
            model.addAttribute("userOwnedLists", currentUser.getUserOwnedLists());
            return "redirect:/";
        }

    @PostMapping("/removeTask")
    public String removeTask(@RequestParam UUID listId, @RequestParam UUID taskId, Model model) {
        User currentUser = userManager.getCurrentUser();
        TodoList todoList = currentUser.getListById(listId);

        todoList.removeTask(taskId);

        //lägg till aktuella användaren och deras listor i modellen
        model.addAttribute("currentUser", currentUser);
        model.addAttribute("userOwnedLists", currentUser.getUserOwnedLists());

        return "redirect:/";
    }
    

       

        
}

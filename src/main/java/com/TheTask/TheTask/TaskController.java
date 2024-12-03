package com.TheTask.TheTask;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class TaskController {

    @Autowired
    private UserManager userManager;
    
    @PostMapping("/newTask")
        public String newTask(@RequestParam String titleTask, @RequestParam UUID listId, String deadline, org.springframework.ui.Model model){
           // Hämta den aktuella användaren 
           User currentUser = userManager.getCurrentUser();

            //hitta listan med listId
            TodoList todoList = currentUser.getListById(listId);


            if (todoList != null) {
        // Om deadline inte väljs skapas task utan deadline
        LocalDate parsedDeadline = null;
        if (deadline != null && !deadline.isEmpty()) {
            parsedDeadline = LocalDate.parse(deadline);
        }
           
            Task newTask = new Task(titleTask, parsedDeadline);
            todoList.addTask(newTask);
        }
            
            //lägg till aktuella användaren och deras listor i modellen
            model.addAttribute("currentUser", currentUser);
            model.addAttribute("userOwnedLists", currentUser.getUserOwnedLists());
            return "redirect:/";
        }

    

        
}

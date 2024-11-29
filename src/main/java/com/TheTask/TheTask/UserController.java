package com.TheTask.TheTask;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller

public class UserController {
    @Autowired
    private UserManager userManager;

    @GetMapping("/")
    public String getHomePage(Model model) {
        User currentUser = userManager.getCurrentUser();
        model.addAttribute("userManager", userManager);
        model.addAttribute("currentUser", currentUser);
        if (currentUser != null){ // kollar om det finns en aktuell användare - finns det en aktuell användare lägger vi till todolist
            model.addAttribute("userOwnedLists", currentUser.getUserOwnedLists());
        }
        return "index";
    }
    

    @GetMapping("/create_user")
    public String getCreateUserPage(Model model){
        model.addAttribute("user", new User(null));
        return "create_user";
    }
    

    @PostMapping("/newUser")
    public String newUser(@ModelAttribute User user, Model model){
        userManager.users.add(user);
        System.out.println("New user ID: " + user.id);
        System.out.println("Number of users: " + userManager.users.size());
        userManager.setCurrentUser(user.id);
        System.out.println("Current user: " + userManager.getCurrentUser().getUserName());
        // lägg till aktuella användaren och deras todolists 
        model.addAttribute("currentUser", user); // lägger till aktuella användaren i modellen så den används i vyn 
        model.addAttribute("userOwnedLists", user.getUserOwnedLists()); // lägger till den aktuella användarens todolist i modellen
        return "redirect:/";
    }

    @PostMapping("/selectUser")
    public String updateCurrentUser(@RequestParam UUID userId, Model model) {
        userManager.setCurrentUser(userId);
        User currentUser = userManager.getCurrentUser(); // hämta aktuella användaren - spara den i currentUser
        System.out.println("Current user: " + userManager.getCurrentUser().getUserName());
        // lägger till aktuella användaren och deras todolists i modellen 
        model.addAttribute("currentUser", currentUser);
        model.addAttribute("userOwnedLists", currentUser); 
    
        return "redirect:/";
    }
    
    
}

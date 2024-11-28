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
        model.addAttribute("userManager", userManager);
        model.addAttribute("currentUser", userManager.getCurrentUser());
        return "index";
    }
    

    @GetMapping("/create_user")
    public String getCreateUserPage(Model model){
        model.addAttribute("user", new User(null));
        return "create_user";
    }
    

    @PostMapping("/newUser")
    public String newUser(@ModelAttribute User user){
        userManager.users.add(user);
        System.out.println("New user ID: " + user.id);
        System.out.println("Number of users: " + userManager.users.size());
        userManager.setCurrentUser(user.id);
        System.out.println("Current user: " + userManager.getCurrentUser().getUserName());
        return "redirect:/";
    }

    @PostMapping("/selectUser")
    public String updateCurrentUser(@RequestParam UUID userId) {
        userManager.setCurrentUser(userId);
        System.out.println("Current user: " + userManager.getCurrentUser().getUserName());
        
        return "redirect:/";
    }
    
    
}

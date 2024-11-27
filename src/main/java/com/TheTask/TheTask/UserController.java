package com.TheTask.TheTask;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class UserController {

    @GetMapping("/create_user")
    public String getCreateUserPage(Model model){
        model.addAttribute("user", new User(null));
        return "create_user";
    }
    
    public List<User> users = new ArrayList<>();


    @PostMapping("/newUser")
    public String newUser(@RequestParam("name") String name){
        users.add(new User(name));
        return "redirect:/create_user";
    }
    
}

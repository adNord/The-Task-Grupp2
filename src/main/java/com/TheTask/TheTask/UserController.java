package com.TheTask.TheTask;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class UserController {

    @GetMapping("/create_user")
    public String getCreateUserPage(){

        return "create_user";
    }

    @PostMapping("/newUser")
    public String newUser(@RequestParam("name") String name){

        return "create_user";
    }
    
}

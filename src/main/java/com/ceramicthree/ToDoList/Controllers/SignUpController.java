package com.ceramicthree.ToDoList.Controllers;

import com.ceramicthree.ToDoList.Models.User;
import com.ceramicthree.ToDoList.Repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignUpController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/signup")
    public String signUpView(){
        return "sign-up";
    }

    @PostMapping("/signup")
    public String signUp(@RequestParam String username, @RequestParam String password, Model model){
        User user = new User(username, password);
        userRepo.save(user);
        return "/login";
    }

}

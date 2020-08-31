package com.ceramicthree.ToDoList.Controllers;

import com.ceramicthree.ToDoList.Models.ToDo;
import com.ceramicthree.ToDoList.Repos.ToDoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddController {
    @Autowired
    private ToDoRepo toDoRepo;

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("title", "New ToDo");
        return "add";
    }

    @PostMapping("/add")
    public String newToDo(@RequestParam String name, @RequestParam String description, @RequestParam String author, Model model){
        ToDo toDo = new ToDo(name, description, author, false);
        toDoRepo.save(toDo);
        return "redirect:/";
    }
}

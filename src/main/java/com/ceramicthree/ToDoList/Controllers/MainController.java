package com.ceramicthree.ToDoList.Controllers;

import com.ceramicthree.ToDoList.Models.ToDo;
import com.ceramicthree.ToDoList.Repos.ToDoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class MainController {
    @Autowired
    private ToDoRepo toDoRepo;

    @GetMapping("/")
    public String main(Model model){
        model.addAttribute("title", "Главная");
        Iterable<ToDo> toDos = toDoRepo.findAll();
        model.addAttribute("todos", toDos);
        return "main";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable(value = "id") Integer id){
        ToDo toDo = toDoRepo.findById(id).orElseThrow();
        toDoRepo.delete(toDo);
        return "redirect:/";
    }
}

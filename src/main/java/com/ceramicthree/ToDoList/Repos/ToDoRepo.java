package com.ceramicthree.ToDoList.Repos;

import com.ceramicthree.ToDoList.Models.ToDo;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepo extends CrudRepository<ToDo, Integer> {

}

package com.api_consumption.todo_service.controller;

import com.api_consumption.todo_service.model.Todo;
import com.api_consumption.todo_service.service.TodosService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("todo")
public class TodosController {
    private TodosService todosService;

    public TodosController(TodosService todosService) {
        this.todosService = todosService;
    }

    @GetMapping
    public List<Todo> getTodos()
    {
        return todosService.getTodos();
    }

    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable int id)
    {
        return todosService.getTodoById(id);
    }
    @GetMapping("/user/{userId}")
    public List<Todo> getTodoByUserid(@PathVariable int userId)
    {
        return todosService.getTodoByUserid(userId);
    }
}

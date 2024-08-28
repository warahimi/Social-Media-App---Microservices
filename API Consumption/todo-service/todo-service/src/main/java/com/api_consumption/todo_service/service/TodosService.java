package com.api_consumption.todo_service.service;

import com.api_consumption.todo_service.model.Todo;
import com.api_consumption.todo_service.reposotory.TodosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodosService {
    private TodosRepository todosRepository;

    public TodosService(TodosRepository todosRepository) {
        this.todosRepository = todosRepository;
    }

    public List<Todo> getTodos()
    {
        return todosRepository.getTodos();
    }

    public Todo getTodoById(int id)
    {
        return todosRepository.getTodoById(id);
    }

    public List<Todo> getTodoByUserid(int userId)
    {
        return todosRepository.getTodoByUserid(userId);
    }
}

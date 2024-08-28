package com.api_consumption.todo_service.reposotory;

import com.api_consumption.todo_service.model.Todo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TodosRepository {
    private List<Todo> todos;

    public TodosRepository()
    {
        this.todos = new ArrayList<>();
    }

    public void setTodos(List<Todo> todos)
    {
        this.todos = todos;
    }

    public List<Todo> getTodos()
    {
        return this.todos;
    }

    public Todo getTodoById(int id)
    {
        return todos.stream()
                .filter(todo -> todo.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Todo> getTodoByUserid(int userId)
    {
        return todos.stream()
                .filter(todo -> todo.getUserId() == userId)
                .collect(Collectors.toList());
    }
}

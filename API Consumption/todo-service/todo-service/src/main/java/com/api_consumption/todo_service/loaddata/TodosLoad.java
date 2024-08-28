package com.api_consumption.todo_service.loaddata;

import com.api_consumption.todo_service.model.Todo;
import com.api_consumption.todo_service.reposotory.TodosRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Component
public class TodosLoad implements CommandLineRunner {
    private RestTemplate standardRestTemplate;
    private TodosRepository todosRepository;

    public TodosLoad(RestTemplate standardRestTemplate, TodosRepository todosRepository) {
        this.standardRestTemplate = standardRestTemplate;
        this.todosRepository = todosRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        Todo[] todos = standardRestTemplate.getForObject("https://jsonplaceholder.typicode.com/todos", Todo[].class);
        todosRepository.setTodos(Arrays.asList(todos));

    }
}

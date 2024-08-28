package com.api_consumption.user_service.loaddata;

import com.api_consumption.user_service.model.Post;
import com.api_consumption.user_service.model.User;
import com.api_consumption.user_service.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Component
public class UserLoad implements CommandLineRunner {
    private RestTemplate standardRestTemplate;
    private UserRepository userRepository;

    public UserLoad(RestTemplate standardRestTemplate,UserRepository userRepository) {
        this.standardRestTemplate = standardRestTemplate;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User[] users = standardRestTemplate.getForObject("https://jsonplaceholder.typicode.com/users", User[].class);
        userRepository.setUsers(Arrays.asList(users));
    }
}

package com.api_consumption.user_service.controller;

import com.api_consumption.user_service.model.Post;
import com.api_consumption.user_service.model.User;
import com.api_consumption.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private RestTemplate standardRestTemplate;
    private RestTemplate loadBalancedRestTemplate;
    private UserService userService;

    public UserController(UserService userService,
                          @Qualifier("loadBalancedRestTemplate") RestTemplate loadBalancedRestTemplate,
                          @Qualifier("standardRestTemplate") RestTemplate standardRestTemplate) {
        this.userService = userService;
        this.loadBalancedRestTemplate = loadBalancedRestTemplate;
        this.standardRestTemplate=standardRestTemplate;
    }
    @GetMapping("/post")
    public List<Post> getPosts()
    {
        Post[] posts = loadBalancedRestTemplate.getForObject("http://post-service/post", Post[].class);
        System.out.println(posts.length);
        return Arrays.asList(posts);
    }

    @GetMapping
    public List<User> getUsers()
    {
        return userService.getUsers();
    }
}

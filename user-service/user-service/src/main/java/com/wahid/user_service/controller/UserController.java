package com.wahid.user_service.controller;

import com.wahid.user_service.entity.User;
import com.wahid.user_service.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers()
    {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public User getUserByUserId(@PathVariable String userId)
    {
        return userService.getUserByUserId(userId);
    }

    @GetMapping("/username/{userName}")
    public User getUserByUserName(@PathVariable String userName)
    {
        return userService.getUserByUserName(userName);
    }
}

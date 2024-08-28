package com.api_consumption.user_service.service;

import com.api_consumption.user_service.model.User;
import com.api_consumption.user_service.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers()
    {
        return userRepository.getUsers();
    }

}

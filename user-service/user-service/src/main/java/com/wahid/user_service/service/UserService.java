package com.wahid.user_service.service;

import com.wahid.user_service.entity.User;
import com.wahid.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers()
    {
        return userRepository.getAllUsers();
    }
    public User getUserByUserId(String userId)
    {
        return userRepository.getUserByUserId(userId);
    }
    public User getUserByUserName(String userName)
    {
        return userRepository.getUserByUserName(userName);
    }
}

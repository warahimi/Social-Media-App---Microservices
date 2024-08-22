package com.wahid.user_service.repository;

import com.wahid.user_service.entity.Notification;
import com.wahid.user_service.entity.Post;
import com.wahid.user_service.entity.User;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class UserRepository {
    private List<User> users;

    RestTemplate restTemplate;

    public UserRepository(RestTemplate restTemplate)
    {
        this.restTemplate=restTemplate;
        this.users = new ArrayList<>();
        users.add(new User("1", "Wahid","7898222",new ArrayList<>(), new ArrayList<>()));
        users.add(new User("2", "Abdullah","9999999",new ArrayList<>(), new ArrayList<>()));
        users.add(new User("3", "Hosna","88888888",new ArrayList<>(), new ArrayList<>()));
        users.add(new User("4", "Farima","77777777777",new ArrayList<>(), new ArrayList<>()));
        load();
    }


    public void load()
    {
        for(User user : users)
        {
            String notificationUrl = "http://localhost:8082/notification/user/"+user.getUserId();
            String postUrl = "http://localhost:8081/post/user/"+ user.getUserId();

            Notification[] notifications = restTemplate.getForObject(notificationUrl,Notification[].class);
            Post[] posts = restTemplate.getForObject(postUrl,Post[].class);
            user.setNotifications(Arrays.asList(notifications));
            user.setPosts(Arrays.asList(posts));
        }
    }

    public List<User> getAllUsers()
    {
        return this.users;
    }
    public User getUserByUserId(String userId)
    {
        for(User user : users)
        {
            if(user.getUserId().equals(userId))
            {
                return user;
            }
        }
        return null;
    }

    public User getUserByUserName(String userName)
    {
        return users.stream()
                .filter(user -> user.getUserName().equals(userName))
                .findFirst()
                .orElse(null);
    }
}

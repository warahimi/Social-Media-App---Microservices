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
    @Autowired
    public UserRepository(RestTemplate restTemplate)
    {
        this.restTemplate=restTemplate;
        this.users = new ArrayList<>();
        users.add(new User("1", "Wahid","7898222",new ArrayList<>(), new ArrayList<>()));
        users.add(new User("2", "Abdullah","9999999",new ArrayList<>(), new ArrayList<>()));
        users.add(new User("3", "Hosna","88888888",new ArrayList<>(), new ArrayList<>()));
        users.add(new User("4", "Farima","77777777777",new ArrayList<>(), new ArrayList<>()));
    }



    public List<User> getAllUsers() {
        for (User user : users) {
            try {
                String notificationUrl = "http://notification-service/notification/user/" + user.getUserId();
                //notificationUrl = notificationUrl.replace("_", "-"); // Replace invalid characters

                String postUrl = "http://post-service/post/user/" + user.getUserId();
                //postUrl = postUrl.replace("_", "-");

                Notification[] notifications = restTemplate.getForObject(notificationUrl, Notification[].class);
                Post[] posts = restTemplate.getForObject(postUrl, Post[].class);

                if (notifications != null) {
                    user.setNotifications(Arrays.asList(notifications));
                }

                if (posts != null) {
                    user.setPosts(Arrays.asList(posts));
                }

            } catch (Exception e) {
                // Log error or handle it gracefully
                System.err.println("Error fetching data for user " + user.getUserId() + ": " + e.getMessage());
            }
        }
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

package com.api_consumption.user_service.repository;

import com.api_consumption.user_service.model.Post;
import com.api_consumption.user_service.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class UserRepository {
    private List<User> users;
    private RestTemplate loadBalancedRestTemplate;

    public UserRepository(RestTemplate loadBalancedRestTemplate)
    {
        this.users = new ArrayList<>();
        this.loadBalancedRestTemplate = loadBalancedRestTemplate;
    }

    public void setUsers(List<User> users)
    {
        this.users = users;
    }
    public List<User> getUsers()
    {
        for(User user : users)
        {
            String url = "http://post-service/post/user/"+user.getId();
            Post[] posts = loadBalancedRestTemplate.getForObject(url, Post[].class);
            user.setPosts(Arrays.asList(posts));

        }
        return this.users;
    }
}

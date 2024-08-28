package com.api_consumption.user_service.repository;

import com.api_consumption.user_service.model.*;
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
            String postUrl = "http://post-service/post/user/"+user.getId();
            Post[] posts = loadBalancedRestTemplate.getForObject(postUrl, Post[].class);

            String todosUrl = "http://todo-service/todo/user/"+user.getId();
            Todo[] todos = loadBalancedRestTemplate.getForObject(todosUrl, Todo[].class);
            user.setPosts(Arrays.asList(posts));
            user.setTodos(Arrays.asList(todos));

            for(Post post : user.getPosts())
            {
                String commentsUrl = "http://comment-service/comment/post/"+post.getId();
                Comment[] postComments = loadBalancedRestTemplate.getForObject(commentsUrl, Comment[].class);
                post.setComments(Arrays.asList(postComments));
            }

            String albumsUrl = "http://album-service/album/user/"+user.getId();
            Album[] albums = loadBalancedRestTemplate.getForObject(albumsUrl, Album[].class);
            user.setAlbums(Arrays.asList(albums));

            for (Album album: user.getAlbums())
            {
                String photosUrl = "htt://photo-service/photo/"+album.getId();
                Photo[] albumPhotos = loadBalancedRestTemplate.getForObject(photosUrl, Photo[].class);
                album.setPhotos(Arrays.asList(albumPhotos));
            }

        }
        return this.users;
    }
}

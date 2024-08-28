package com.api_consumption.post_service.repository;

import com.api_consumption.post_service.model.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepsitory {
    private List<Post> posts;

    public PostRepsitory() {
        this.posts = new ArrayList<>();
    }
    public void setPosts(List<Post> posts)
    {
        this.posts = posts;
    }

    public List<Post> getPosts()
    {
        return this.posts;
    }

    public Post getPostById(int id)
    {
        return posts
                .stream()
                .filter(post -> post.getId() == id)
                .findFirst()
                .orElse(null);
    }
    public List<Post> getPostsByUserId(int userId)
    {
        return posts.stream()
                .filter(post -> post.getUserId() == userId)
                .collect(Collectors.toList());
    }
}

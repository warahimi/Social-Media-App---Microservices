package com.wahid.post_service.repository;

import com.wahid.post_service.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepository {
    private List<Post> posts;

    public PostRepository()
    {
        this.posts = new ArrayList<>();

        posts.add(new Post("1P","1","this post 1P"));
        posts.add(new Post("2P","1","this post 2P"));
        posts.add(new Post("3P","2","this post 3P"));
        posts.add(new Post("4P","2","this post 4P"));
        posts.add(new Post("5P","3","this post 5P"));
        posts.add(new Post("6P","4","this post 6P"));
        posts.add(new Post("7P","4","this post 7P"));
        posts.add(new Post("8P","4","this post 8P"));
        posts.add(new Post("9P","1","this post 9P"));
        posts.add(new Post("10P","3","this post 10P"));
    }

    public List<Post> getAllPosts()
    {
        return this.posts;
    }
    public Post getPostById(String postId)
    {
        return posts.stream()
                .filter(post -> post.getPostId().equals(postId))
                .findFirst()
                .orElse(null);
    }
    public List<Post> getPostByUserId(String userId)
    {
        List<Post> result = posts.stream()
                .filter(post -> post.getUserId().equals(userId))
                .collect(Collectors.toList());
        return result;
    }
}

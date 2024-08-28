package com.api_consumption.post_service.controller;

import com.api_consumption.post_service.model.Post;
import com.api_consumption.post_service.service.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getPosts()
    {
        return postService.getPosts();
    }
    @GetMapping("/{id}")
    public Post getPostById(@PathVariable int id)
    {
        return postService.getPostById(id);
    }
    @GetMapping("/user/{userId}")
    public List<Post> getPostsByUserId(@PathVariable("userId") int userId)
    {
        return postService.getPostsByUserId(userId);
    }

}

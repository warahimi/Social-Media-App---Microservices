package com.wahid.post_service.controller;

import com.wahid.post_service.entity.Post;
import com.wahid.post_service.service.PostService;
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
    public List<Post> getAllPost()
    {
        return postService.getAllPosts();
    }

    @GetMapping("/{postId}")
    public Post getPostById(@PathVariable String postId)
    {
        return postService.getPostById(postId);
    }
    @GetMapping("/user/{userId}")
    public List<Post> getPostByUserId(@PathVariable String userId)
    {
        return postService.getPostByUserId(userId);
    }
}

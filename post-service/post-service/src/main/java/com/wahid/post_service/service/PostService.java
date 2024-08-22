package com.wahid.post_service.service;

import com.wahid.post_service.entity.Post;
import com.wahid.post_service.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPosts()
    {
        return postRepository.getAllPosts();
    }
    public Post getPostById(String postId)
    {
        return postRepository.getPostById(postId);
    }

    public List<Post> getPostByUserId(String userId)
    {
        return postRepository.getPostByUserId(userId);
    }
}

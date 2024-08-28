package com.api_consumption.post_service.service;

import com.api_consumption.post_service.model.Post;
import com.api_consumption.post_service.repository.PostRepsitory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private PostRepsitory postRepsitory;

    public PostService(PostRepsitory postRepsitory) {
        this.postRepsitory = postRepsitory;
    }

    public List<Post> getPosts()
    {
        return postRepsitory.getPosts();
    }
    public Post getPostById(int id)
    {
        return postRepsitory.getPostById(id);
    }
    public List<Post> getPostsByUserId(int userId)
    {
        return postRepsitory.getPostsByUserId(userId);
    }
}

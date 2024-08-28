package com.api_consumption.comment_service.loaddata;

import com.api_consumption.comment_service.model.Comment;
import com.api_consumption.comment_service.repository.CommentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Component
public class CommentLoad implements CommandLineRunner {
    private CommentRepository commentRepository;
    private RestTemplate standardRestTemplate;

    public CommentLoad(CommentRepository commentRepository,RestTemplate standardRestTemplate) {
        this.commentRepository = commentRepository;
        this.standardRestTemplate = standardRestTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        Comment[] comm = standardRestTemplate.getForObject("https://jsonplaceholder.typicode.com/comments", Comment[].class);
        commentRepository.setComments(Arrays.asList(comm));
    }
}

package com.api_consumption.comment_service.controller;

import com.api_consumption.comment_service.model.Comment;
import com.api_consumption.comment_service.service.CommentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<Comment> getComments()
    {
        return commentService.getComments();
    }
    @GetMapping("/{id}")
    public Comment ggetCommentById(@PathVariable int id)
    {
        return commentService.getCommentById(id);
    }
    @GetMapping("/post/{postId}")
    public List<Comment> getCommentsByPostId(@PathVariable int postId)
    {
        return commentService.getCommentsByPostId(postId);
    }

}

package com.api_consumption.comment_service.service;

import com.api_consumption.comment_service.model.Comment;
import com.api_consumption.comment_service.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> getComments()
    {
        return commentRepository.getComments();
    }
    public Comment getCommentById(int id)
    {
        return commentRepository.getCommentById(id);
    }
    public List<Comment> getCommentsByPostId(int postId)
    {
        return commentRepository.getCommentsByPostId(postId);
    }
}

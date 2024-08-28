package com.api_consumption.comment_service.repository;

import com.api_consumption.comment_service.model.Comment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CommentRepository {
    private List<Comment> comments;

    public CommentRepository() {
        this.comments = new ArrayList<>();
    }

    public void setComments(List<Comment> comments)
    {
        this.comments = comments;
    }
    public List<Comment> getComments()
    {
        return this.comments;
    }

    public Comment getCommentById(int id) {
        return comments.stream()
                .filter(comment -> comment.getId() ==id)
                .findFirst()
                .orElse(null);
    }

    public List<Comment> getCommentsByPostId(int postId)
    {
        return comments.stream()
                .filter(comment -> comment.getPostId() == postId)
                .collect(Collectors.toList());
    }
}

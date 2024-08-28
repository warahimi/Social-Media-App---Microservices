package com.api_consumption.comment_service.model;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Comment {
    private int postId;
    private int id;
    private String name;
    private String email;
    private String body;
}

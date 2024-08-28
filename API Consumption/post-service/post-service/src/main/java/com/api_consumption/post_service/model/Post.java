package com.api_consumption.post_service.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Post {
    private int userId;
    private int id;
    private String title;

    private String body;
}

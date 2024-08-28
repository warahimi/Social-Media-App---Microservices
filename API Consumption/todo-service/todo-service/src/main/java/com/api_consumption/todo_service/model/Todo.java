package com.api_consumption.todo_service.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Todo {
    private int userId;
    private int id;
    private String title;
    private boolean completed;

}

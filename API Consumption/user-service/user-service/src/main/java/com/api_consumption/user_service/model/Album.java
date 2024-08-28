package com.api_consumption.user_service.model;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Album {
    private int userId;
    private int id;
    private String title;
    private List<Photo> photos;
}

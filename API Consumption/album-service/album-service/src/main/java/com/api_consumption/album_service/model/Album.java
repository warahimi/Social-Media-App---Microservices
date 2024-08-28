package com.api_consumption.album_service.model;

import lombok.*;
import org.springframework.stereotype.Component;

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
}

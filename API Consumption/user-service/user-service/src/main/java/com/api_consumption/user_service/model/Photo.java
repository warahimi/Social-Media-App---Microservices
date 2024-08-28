package com.api_consumption.user_service.model;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Photo {
    private int albumId;
    private int id;
    private String title;
    private String url;
    private String thumbnailUrl;
}

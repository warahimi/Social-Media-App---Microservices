package com.api_consumption.album_service.controller;

import com.api_consumption.album_service.model.Album;
import com.api_consumption.album_service.service.AlbumService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/album")
public class AlbumController {
    private AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }
    @GetMapping
    public List<Album> getAlbums()
    {
        return albumService.getAlbums();
    }
    @GetMapping("/user/{userId}")
    public List<Album> getAlbumsByUserId(@PathVariable int userId)
    {
        return albumService.getAlbumsByUserId(userId);
    }
}

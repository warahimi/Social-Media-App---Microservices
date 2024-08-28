package com.api_consumption.photo_service.controller;

import com.api_consumption.photo_service.modle.Photo;
import com.api_consumption.photo_service.service.PhotoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/photo")

public class PhotoController {
    private PhotoService photoService;

    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }
    @GetMapping("/{albumId}")
    public List<Photo> getPhotosByAlbumId(@PathVariable int albumId)
    {
        return photoService.getPhotosByAlbumId(albumId);
    }
}

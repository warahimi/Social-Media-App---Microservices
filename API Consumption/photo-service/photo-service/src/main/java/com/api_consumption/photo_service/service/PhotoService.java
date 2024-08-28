package com.api_consumption.photo_service.service;

import com.api_consumption.photo_service.modle.Photo;
import com.api_consumption.photo_service.repository.PhotoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoService {
    private PhotoRepository photoRepository;

    public PhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    public List<Photo> getPhotosByAlbumId(int albumId)
    {
        return photoRepository.getPhotosByAlbumId(albumId);
    }
}

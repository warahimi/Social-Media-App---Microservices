package com.api_consumption.photo_service.repository;

import com.api_consumption.photo_service.modle.Photo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PhotoRepository {
    private List<Photo> photos;

    public PhotoRepository() {
        this.photos = new ArrayList<>();
    }

    public void setPhotos(List<Photo> photos)
    {
        this.photos= photos;
    }
    public List<Photo> getPhotosByAlbumId(int albumId)
    {
        return photos.stream()
                .filter(photo -> photo.getAlbumId() == albumId)
                .collect(Collectors.toList());
    }
}

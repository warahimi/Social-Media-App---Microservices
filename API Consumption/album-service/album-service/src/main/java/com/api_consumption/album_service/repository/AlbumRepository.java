package com.api_consumption.album_service.repository;

import com.api_consumption.album_service.model.Album;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class AlbumRepository {
    private List<Album> albums;

    public AlbumRepository() {
        this.albums = new ArrayList<>();
    }

    public void setAlbums(List<Album> albums)
    {
        this.albums = albums;
    }

    public List<Album> getAlbums()
    {
        return this.albums;
    }
    public List<Album> getAlbumsByUserId(int userId)
    {
        return albums.stream()
                .filter(album -> album.getUserId() == userId)
                .collect(Collectors.toList());
    }
}

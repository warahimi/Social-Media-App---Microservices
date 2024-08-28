package com.api_consumption.album_service.service;

import com.api_consumption.album_service.model.Album;
import com.api_consumption.album_service.repository.AlbumRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {
    private AlbumRepository albumRepository;

    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public List<Album> getAlbums()
    {
        return albumRepository.getAlbums();
    }
    public List<Album> getAlbumsByUserId(int userId)
    {
        return albumRepository.getAlbumsByUserId(userId);
    }
}

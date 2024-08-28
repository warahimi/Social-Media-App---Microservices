package com.api_consumption.album_service.loaddata;

import com.api_consumption.album_service.model.Album;
import com.api_consumption.album_service.repository.AlbumRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Component
public class AlbumLoad implements CommandLineRunner {

    private RestTemplate standardRestTemplate;

    private AlbumRepository albumRepository;

    public AlbumLoad(RestTemplate standardRestTemplate, AlbumRepository albumRepository) {
        this.standardRestTemplate = standardRestTemplate;
        this.albumRepository = albumRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Album[] albums = standardRestTemplate.getForObject("https://jsonplaceholder.typicode.com/albums", Album[].class);
        albumRepository.setAlbums(Arrays.asList(albums));
        System.out.println("Size: "+ albums.length);
    }
}

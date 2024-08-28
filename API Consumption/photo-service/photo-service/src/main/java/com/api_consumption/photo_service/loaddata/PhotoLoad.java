package com.api_consumption.photo_service.loaddata;

import com.api_consumption.photo_service.modle.Photo;
import com.api_consumption.photo_service.repository.PhotoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Component
public class PhotoLoad implements CommandLineRunner {
    private PhotoRepository photoRepository;
    private RestTemplate restTemplate;

    public PhotoLoad(PhotoRepository photoRepository, RestTemplate restTemplate) {
        this.photoRepository = photoRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        Photo[] photos = restTemplate.getForObject("https://jsonplaceholder.typicode.com/photos", Photo[].class);
        photoRepository.setPhotos(Arrays.asList(photos));
    }
}

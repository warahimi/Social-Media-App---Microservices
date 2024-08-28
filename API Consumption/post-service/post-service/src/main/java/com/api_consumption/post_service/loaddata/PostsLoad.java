package com.api_consumption.post_service.loaddata;

import com.api_consumption.post_service.model.Post;
import com.api_consumption.post_service.repository.PostRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Component
public class PostsLoad implements CommandLineRunner {

    private final PostRepsitory postRepsitory;
    private final RestTemplate standardRestTemplate;
    private final RestTemplate loadBalancedRestTemplate;

    @Autowired
    public PostsLoad(PostRepsitory postRepsitory,
                     @Qualifier("standardRestTemplate") RestTemplate standardRestTemplate,
                     @Qualifier("loadBalancedRestTemplate") RestTemplate loadBalancedRestTemplate) {
        this.postRepsitory = postRepsitory;
        this.standardRestTemplate = standardRestTemplate;
        this.loadBalancedRestTemplate = loadBalancedRestTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        // Call an external service
        Post[] posts = standardRestTemplate.getForObject("https://jsonplaceholder.typicode.com/posts", Post[].class);
        postRepsitory.setPosts(Arrays.asList(posts));

        // Example: Call another microservice registered with Eureka
        //AnotherServiceResponse response = loadBalancedRestTemplate.getForObject("http://another-microservice/endpoint", AnotherServiceResponse.class);
        // Process the response...
    }
}
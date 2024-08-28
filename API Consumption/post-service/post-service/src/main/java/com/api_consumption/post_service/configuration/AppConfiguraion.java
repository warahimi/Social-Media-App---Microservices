package com.api_consumption.post_service.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfiguraion {
    //This RestTemplate will be used for calling services registered with Eureka.
    @Bean
    @LoadBalanced
    public RestTemplate loadBalancedRestTemplate() {
        return new RestTemplate();
    }

    //This RestTemplate will be used for calling external services that are not part of your microservice ecosystem.
    @Bean
    public RestTemplate standardRestTemplate() {
        return new RestTemplate();
    }

}

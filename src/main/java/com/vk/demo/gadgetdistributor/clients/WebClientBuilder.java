package com.vk.demo.gadgetdistributor.clients;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

public class WebClientBuilder {

    @Bean
    @LoadBalanced
    public static WebClient.Builder create() {
        return WebClient.builder();
    }

}

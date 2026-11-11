package org.maciek.recommendationms;

import org.springframework.boot.restclient.autoconfigure.RestClientBuilderConfigurer;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestClient;

@Configuration
public class Config {

    @Bean
    @Primary
    public RestClient.Builder restClientBuilder(
            RestClientBuilderConfigurer configurer) {
        return configurer.configure(RestClient.builder());
    }

//    @Bean
//    @LoadBalanced //client side load balancing
//    public RestClient.Builder loadBalancedRestClientBuilder(
//            RestClientBuilderConfigurer configurer) {
//        return configurer.configure(RestClient.builder());
//    }

}

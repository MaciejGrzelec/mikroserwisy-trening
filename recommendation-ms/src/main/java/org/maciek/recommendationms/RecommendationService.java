package org.maciek.recommendationms;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Map;

@Service
public class RecommendationService {
    private final RestClient restClient;
//    private final String contentServiceUrl;
//    public RecommendationService(@LoadBalanced RestClient.Builder builder) {
//        this.restClient = builder.build();
//    }

    public RecommendationService(RestClient.Builder builder
//            ,@Value("${content.service.url}") String contentServiceUrl)
                                 ) {
        this.restClient = builder
//                .baseUrl(contentServiceUrl)
                .build();
    }

    public List<ContentResponse> getRecommendationByTag(String tag) {
        return restClient.get()
//                .uri("/api/content/tag/{tag}", tag) CLIENT SIDE LOAD BALANCER
                .uri("http://localhost:8080/api/content/tag/{tag}", tag)
                .retrieve()
                .body(new ParameterizedTypeReference<List<ContentResponse>>() {});
    }
}

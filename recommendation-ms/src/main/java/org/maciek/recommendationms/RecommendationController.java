package org.maciek.recommendationms;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/recommendation")
public class RecommendationController {

    private final RecommendationService recommendationService;

    @GetMapping("/tag/{tag}")
    public List<ContentResponse> getRecommendations(@PathVariable String tag) {
        List<ContentResponse> recommendationByTab = recommendationService.getRecommendationByTag(tag);
        return recommendationByTab;
    }
}

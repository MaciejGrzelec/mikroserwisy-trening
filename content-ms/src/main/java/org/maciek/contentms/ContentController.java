package org.maciek.contentms;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/content")
@RequiredArgsConstructor
public class ContentController {

    private final ContentRepository contentRepository;

    @GetMapping
    public List<Content> getContent() {
        return contentRepository.findAll();
    }

    @GetMapping("/tag/{tag}")
    public List<Content> get(@PathVariable String tag) {
        return contentRepository.findByTagIgnoreCase(tag);
    }
}

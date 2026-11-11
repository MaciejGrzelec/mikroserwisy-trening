package com.maciek.ms1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("properties")
@RefreshScope
public class PropertyController {
    @Value("${message:defaultValue}")
    private String message;

    @GetMapping
    public String getMessage() {
        return this.message;
    }
}

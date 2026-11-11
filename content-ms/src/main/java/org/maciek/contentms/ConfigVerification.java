package org.maciek.contentms;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConfigVerification implements ApplicationRunner {

    @Value("${content.config-source}")
    private String configSource;

    @Override
    public void run(ApplicationArguments args) {
        System.out.println("Config source: " + configSource);
    }
}

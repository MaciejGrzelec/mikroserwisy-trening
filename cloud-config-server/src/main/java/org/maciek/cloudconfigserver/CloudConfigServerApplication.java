package org.maciek.cloudconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableConfigServer
public class CloudConfigServerApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext run = SpringApplication.run(CloudConfigServerApplication.class, args);
    }

}

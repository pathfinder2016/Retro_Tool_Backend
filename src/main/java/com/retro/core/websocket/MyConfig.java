package com.retro.core.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
    @Bean
    public EndpointConfig newConfigure()
    {
        return new EndpointConfig();
    }
}

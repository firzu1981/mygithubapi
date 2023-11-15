package com.example.mygithubapi.getfromgithubclient.config;

import feign.codec.Decoder;
import feign.jackson.JacksonDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GetFromGithubClientConfig {
    @Bean
    public Decoder feignDecoder() {
        return new JacksonDecoder();
    }
}

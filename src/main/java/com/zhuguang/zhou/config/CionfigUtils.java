package com.zhuguang.zhou.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CionfigUtils {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

package com.springcloud.auth.config;

import com.springcloud.common.handler.GlobalExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: James Wang
 * @Data: 2018/1/4 15:22
 */
@Configuration
public class AuthConfiguration {
    @Bean
    public GlobalExceptionHandler globalExceptionHandler(){
        return new GlobalExceptionHandler();
    }
}

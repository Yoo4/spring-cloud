package com.github.wxiaoqi.learning.auth;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by ace on 2017/9/6.
 */
@SpringBootApplication
@EnableEurekaClient
@ComponentScan("com.github.wxiaoqi.learning.auth")
public class AuthServerBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(AuthServerBootstrap.class,args);
    }
}

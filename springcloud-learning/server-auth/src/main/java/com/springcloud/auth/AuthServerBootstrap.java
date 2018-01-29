package com.springcloud.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication//(exclude={DataSourceAutoConfiguration.class})
@EnableEurekaClient
@ComponentScan("com.springcloud.auth")
@MapperScan("com.springcloud.auth.mapper")
public class AuthServerBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(AuthServerBootstrap.class,args);
    }
}

package com.springcloud.uc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan("com.springcloud.uc")
@MapperScan("com.springcloud.uc.mapper")
@EnableTransactionManagement
public class UseServiceBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(UseServiceBootstrap.class, args);
    }
}

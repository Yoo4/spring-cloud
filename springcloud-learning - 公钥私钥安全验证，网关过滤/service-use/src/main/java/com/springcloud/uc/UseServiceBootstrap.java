package com.springcloud.uc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.springcloud.uc.mapper")
@EnableTransactionManagement
public class UseServiceBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(UseServiceBootstrap.class, args);
    }
}

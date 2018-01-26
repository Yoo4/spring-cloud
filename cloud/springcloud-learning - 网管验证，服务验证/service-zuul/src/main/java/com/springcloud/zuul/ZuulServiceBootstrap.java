package com.springcloud.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EnableZuulProxy
@EnableEurekaClient
@ComponentScan("com.springcloud.zuul")
public class ZuulServiceBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(ZuulServiceBootstrap.class,args);
    }
}

package com.rurekaclient1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class RurekaClient1Application {

	public static void main(String[] args) {
		SpringApplication.run(RurekaClient1Application.class, args);
	}

	@Value("${server.port}")
	String port;
	@RequestMapping("/wang")
	public String home() {
		return "欢迎使用wz的订单服务 端口号:" +port;
	}
}

package com.springboot.in.action

import org.springframework.boot.SpringApplication

object LightSwordApplication extends App {
  System.setProperty("spring.devtools.restart.enabled", "false")
  SpringApplication.run(classOf[AppConfig])
}

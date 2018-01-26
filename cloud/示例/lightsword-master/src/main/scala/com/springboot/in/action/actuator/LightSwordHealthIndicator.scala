package com.springboot.in.action.actuator

import org.springframework.boot.actuate.health.{Health, HealthIndicator}
import org.springframework.stereotype.Component

/**
  * Created by jack on 2017/5/3.
  */
@Component
class LightSwordHealthIndicator extends HealthIndicator {
  override def health(): Health = {
    val errorCode = 0 //doCheck(); // perform some specific health check
    if (errorCode != 0)
      Health.down().withDetail("Error Code", errorCode).build()
    else
      Health.up().withDetail("Error Code", errorCode).build()
  }
}

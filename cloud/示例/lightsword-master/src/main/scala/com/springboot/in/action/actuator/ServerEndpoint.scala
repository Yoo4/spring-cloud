package com.springboot.in.action.actuator

import java.net.InetAddress
import java.util

import org.springframework.boot.actuate.endpoint.Endpoint
import org.springframework.stereotype.Component

/**
  * Created by jack on 2017/5/3.
  */
@Component
class ServerEndpoint extends Endpoint[java.util.List[String]] {
  override def invoke(): java.util.List[String] = {
    val serverDetails = new util.ArrayList[String]
    try {
      serverDetails.add("Server IP Address : " + InetAddress.getLocalHost.getHostAddress)
      serverDetails.add("Server OS : " + System.getProperty("os.name").toLowerCase)
    } catch {
      case e: Exception =>
        e.printStackTrace()
    }
    serverDetails
  }

  override def getId: String = "server"
  override def isSensitive: Boolean = false
  override def isEnabled: Boolean = true
}



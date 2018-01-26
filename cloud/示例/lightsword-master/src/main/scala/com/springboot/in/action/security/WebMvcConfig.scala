package com.springboot.in.action.security

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.{ViewControllerRegistry, WebMvcConfigurerAdapter}


/**
  * Created by jack on 2017/4/30.
  */
@Configuration
class WebMvcConfig extends WebMvcConfigurerAdapter {
  /**
    * 统一注册纯RequestMapping跳转View的Controller
    */
  override def addViewControllers(registry: ViewControllerRegistry) {
    registry.addViewController("/login").setViewName("/login")
  }


  import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry

  /**
    * static resources mapping
    * @param registry
    */
  override def addResourceHandlers(registry: ResourceHandlerRegistry): Unit = { //Swagger ui Mapping
    registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/")
    registry.addResourceHandler("/js/*").addResourceLocations("classpath:/public/js/")
    registry.addResourceHandler("/css/*").addResourceLocations("classpath:/public/css/")
    registry.addResourceHandler("/fonts/*").addResourceLocations("classpath:/public/fonts/")
  }
}

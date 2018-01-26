package com.springcloud.uc.rest;

import com.springcloud.common.context.BaseContextHandler;
import com.springcloud.common.rest.BaseController;
import com.springcloud.uc.biz.BaseUserBiz;
import com.springcloud.uc.entity.BaseUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UseRest extends BaseController<BaseUserBiz,BaseUser>{
    @Value("${itOcean:wrong}")
    private String language;

    @RequestMapping("/hello")
    public String helloWord() {
        return language+" James";
    }

    @RequestMapping("/who")
    public String getCurrentUser() {
        return BaseContextHandler.getUsername();
    }


}

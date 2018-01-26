package com.springcloud.auth.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: James Wang
 * @Data: 2018/1/8 15:10
 */
@RestController
@RequestMapping("client")
public class ClientRest {
    @RequestMapping(value = "/token",method = RequestMethod.POST)
    public String getAccessToken(String clientId,String secret) {
        return null;
    }

    @RequestMapping(value="/myClient")
    public List<String> getAllowedClient(String clientId,String secret) {
        return null;
    }
}

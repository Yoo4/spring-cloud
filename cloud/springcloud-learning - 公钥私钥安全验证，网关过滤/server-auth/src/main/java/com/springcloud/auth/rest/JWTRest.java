package com.springcloud.auth.rest;

import com.springcloud.auth.bean.UserInfo;
import com.springcloud.auth.service.UserService;
import com.springcloud.auth.util.JWTUtil;
import com.springcloud.common.vo.ObjectRestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: James Wang
 * @Data: 2018/1/4 14:36
 */

@RestController
@RequestMapping("jwt")
public class JWTRest {
    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private UserService userService;
    @RequestMapping(value = "/token",method = RequestMethod.POST)
    public ObjectRestResponse authorize(String username,String password) throws Exception {
        //1、校验账户合法性   2、合法则生成token   3、返回，status 401
        UserInfo userInfo = userService.login(username, password);
        return new ObjectRestResponse<String>().data(jwtUtil.generateToken(userInfo));   //返回token对象
    }
}

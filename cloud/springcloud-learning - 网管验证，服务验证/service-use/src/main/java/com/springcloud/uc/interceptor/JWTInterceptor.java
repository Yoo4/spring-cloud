package com.springcloud.uc.interceptor;

import com.springcloud.common.context.BaseContextHandler;
import com.springcloud.common.util.jwt.IJWTInfo;
import com.springcloud.uc.jwt.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: James Wang
 * @Data: 2018/1/5 13:56
 */
@Configuration
public class JWTInterceptor extends HandlerInterceptorAdapter{

    @Value("${jwt.token-header}")
    private String tokenHeader;

    @Autowired
    private JWTUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        System.out.println("这里是新建的拦截器");
        String token = request.getHeader(tokenHeader);
        IJWTInfo infoFromToken = jwtUtil.getInfoFromToken(token);
        BaseContextHandler.setUsername(infoFromToken.getUsername());
        BaseContextHandler.setName(infoFromToken.getName());
        BaseContextHandler.setUserId(infoFromToken.getUserId());

        return super.preHandle(request, response, handler);
    }
}

package com.springcloud.zuul.filter;

import com.alibaba.fastjson.JSON;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.springcloud.common.constants.CommonConstants;
import com.springcloud.common.util.jwt.IJWTInfo;
import com.springcloud.common.vo.BaseResponse;
import com.springcloud.zuul.jwt.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.assertEquals;


/**
 * @Auther: James Wang
 * @Data: 2018/1/5 10:07
 */
@Component
public class AccessFilter extends ZuulFilter{
    @Autowired
    private JWTUtil jwtUtil;
    //"pre"前置校验，"post"后置校验
    @Override
    public String filterType() {
        return "pre";
    }
    //启动顺寻
    @Override
    public int filterOrder() {
        return 0;
    }
    //是否启动
    @Override
    public boolean shouldFilter() {
        return true;
    }
    //做校验
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        if(request.getRequestURI().substring("/api".length()).startsWith("/auth/jwt"))
            return null;
        String token = request.getHeader("access-token");
        try {
            IJWTInfo infoFromToken = jwtUtil.getInfoFromToken(token);
            assertEquals(infoFromToken.getUsername(),"admin");
        } catch (Exception e) {
            ctx.setResponseBody(JSON.toJSONString(new BaseResponse(CommonConstants.EX_TOKEN_ERROR_CODE,"Token error or expired")));
            e.printStackTrace();
        }
        return null;
    }
}

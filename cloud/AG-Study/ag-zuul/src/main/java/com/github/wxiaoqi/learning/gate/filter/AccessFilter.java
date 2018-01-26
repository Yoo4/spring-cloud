package com.github.wxiaoqi.learning.gate.filter;

import com.alibaba.fastjson.JSON;
import com.github.wxiaoqi.learning.common.constants.CommonConstants;
import com.github.wxiaoqi.learning.common.util.jwt.IJWTInfo;
import com.github.wxiaoqi.learning.common.vo.BaseResponse;;
import com.github.wxiaoqi.learning.gate.jwt.JWTUtil;
import com.github.wxiaoqi.learning.gate.rpc.ClientAuthRpc;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by ace on 2017/9/10.
 */
@Component
public class AccessFilter extends ZuulFilter {

   // @Value("${zuul.prefix}")
  //  private String zuulPrefix;
 //   @Value("${jwt.token-header}")
   // private String jwtTokenHeader;


    @Autowired
    private JWTUtil jwtUtil;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        if (request.getRequestURI().substring("/api".length()).startsWith("/auth/jwt"))
            return null;
//        if (isIgnorePath(request.getRequestURI()))
//            return null;
      //  String token = request.getHeader(jwtTokenHeader);
        String token = request.getHeader("access-token");
        try {
            // 验证用户合法性
            IJWTInfo infoFromToken = jwtUtil.getInfoFromToken(token);
            // todo 用户权限
           assertEquals(infoFromToken.getUniqueName(),"admin");

        } catch (Exception e) {
            ctx.setResponseBody(JSON.toJSONString(new BaseResponse(CommonConstants.EX_TOKEN_ERROR_CODE, "Token error or Token is Expired！")));
            e.printStackTrace();
        }
        return null;
    }

//    private boolean isIgnorePath(String path) {
//        for (String url : jwtIgnoreUrl.split(",")) {
//            if (path.substring(zuulPrefix.length()).startsWith(url)) {
//                return true;
//            }
//        }
//        return false;
//    }
}

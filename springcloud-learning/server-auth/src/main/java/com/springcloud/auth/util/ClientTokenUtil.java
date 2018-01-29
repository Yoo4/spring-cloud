package com.springcloud.auth.util;

import com.springcloud.common.util.jwt.IJWTInfo;
import com.springcloud.common.util.jwt.JWTHelper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: James Wang
 * @Data: 2018/1/8 15:24
 */
@Configuration
public class ClientTokenUtil {
    @Value("${client.expire}")
    private int expireTime;
    @Value("${client.pri-key.path}")
    private String priKeyPath;
    @Value("${client.pub-key.path}")
    private String pubKeyPath;

    /**
     * @Date: 2018/1/3 11:12
     * @Content: Token中放入的内容 name account(username) userId expire过期时间
     */
    public String generateToken(IJWTInfo jwtInfo) throws Exception {
        return JWTHelper.generateToken(jwtInfo,priKeyPath,expireTime);
    }


    public IJWTInfo getInfoFromToken(String token) throws Exception {
        return JWTHelper.getInfoFromToken(token,pubKeyPath);
    }
}

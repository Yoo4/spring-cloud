package com.springcloud.uc.jwt;

import com.springcloud.common.util.jwt.IJWTInfo;
import com.springcloud.common.util.jwt.JWTHelper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Auther: James Wang
 * @Data: 2018/1/5 10:21
 */
@Component
public class JWTUtil {
    @Value("${jwt.pub-key.path}")
    private String pubKeyPath;

    /**
     * 公钥解析，校验密钥正确性
     * @param token
     * @return
     * @throws Exception
     */
    public IJWTInfo getInfoFromToken(String token) throws Exception {
        return JWTHelper.getInfoFromToken(token,pubKeyPath);
    }
}

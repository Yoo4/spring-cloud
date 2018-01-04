package com.springcloud.common.util.jwt;

import com.springcloud.common.constants.CommonConstants;
import com.springcloud.common.util.KeyHelper;
import com.springcloud.common.util.StringHelper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.joda.time.DateTime;

/**
 * @Auther: James Wang
 * @Data: 2018/1/4 10:51
 */

public class JWTHelper {
    /**
     * 密钥加密token
     * @param jwtInfo
     * @param priKeyPath
     * @param expireTime
     * @return
     * @throws Exception
     */
    public static String generateToken(IJWTInfo jwtInfo,String priKeyPath,int expireTime) throws Exception {

        System.out.println("起始时间:"+ DateTime.now().toDate()+"  有效时间为:"+expireTime+" 过期时间："+DateTime.now().plusSeconds(expireTime).toDate());

        String compactJws = Jwts.builder()
                .setSubject(jwtInfo.getUsername())
                .claim(CommonConstants.JWT_KEY_USERID,jwtInfo.getUserId())
                .claim(CommonConstants.JWT_KEY_NAME,jwtInfo.getName())
                .setIssuedAt(DateTime.now().toDate())
                .setExpiration(DateTime.now().plusSeconds(expireTime).toDate())
                .signWith(SignatureAlgorithm.RS256, KeyHelper.getPrivateKey(priKeyPath))
                .compact();
        return compactJws;
    }

    /**
     * 公钥解析token
     * @param token
     * @param pubKeyPath
     * @return
     * @throws Exception
     */
    public static Jws<Claims> parserToken(String token,String pubKeyPath) throws Exception {
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(KeyHelper.getPublicKey(pubKeyPath)).parseClaimsJws(token);
        return claimsJws;
    }
    
    /**
     * @Date: 2018/1/4 10:55
     * @Content: 获取token中的用户信息内容
     */
    public static IJWTInfo getInfoFromToken(String token,String pubKeyPath) throws Exception {
        Jws<Claims> claimsJws = parserToken(token,pubKeyPath);
        Claims body = claimsJws.getBody();
        return new JWTInfo(body.getSubject(), StringHelper.getObjectValue(body.get(CommonConstants.JWT_KEY_USERID)),StringHelper.getObjectValue(body.get(CommonConstants.JWT_KEY_NAME)));
    }
}

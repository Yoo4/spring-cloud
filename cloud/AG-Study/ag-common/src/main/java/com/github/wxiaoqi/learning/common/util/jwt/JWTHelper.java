package com.github.wxiaoqi.learning.common.util.jwt;

import com.github.wxiaoqi.learning.common.constants.CommonConstants;
import com.github.wxiaoqi.learning.common.util.KeyHelper;
import com.github.wxiaoqi.learning.common.util.StringHelper;
import com.sun.org.apache.xml.internal.security.algorithms.SignatureAlgorithm;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.joda.time.DateTime;

/**
 * Created by ace on 2017/9/10.
 */
public class JWTHelper {

    /**
     * 私钥加密，生成token
     *
     * @param jwtInfo
     * @param priKeyPath
     * @param expire
     * @return
     * @throws Exception
     */
    public static String generateToken(IJWTInfo jwtInfo, String priKeyPath, int expire) throws Exception {
        String compactJws = Jwts.builder()
                .setSubject(jwtInfo.getUniqueName())//代表这个JWT的主体，即它的所有人是谁
                .claim(CommonConstants.JWT_KEY_USER_ID, jwtInfo.getId())//用户名
                .claim(CommonConstants.JWT_KEY_NAME, jwtInfo.getName())//用户id
                .setExpiration(DateTime.now().plusSeconds(expire).toDate())//时间戳，代表这个JWT的过期时间；
                .signWith(SignatureAlgorithm.RS256, KeyHelper.getPrivateKey(priKeyPath))//私钥密钥加密
                .compact();
        return compactJws;
    }

    /**
     * 公钥解析token
     *
     * @param token
     * @return
     * @throws Exception
     */
    public static Jws<Claims> parserToken(String token, String pubKeyPath) throws Exception {
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(KeyHelper.getPublicKey(pubKeyPath)).parseClaimsJws(token);
        return claimsJws;
    }

    /**
     * 获取token中的用户信息
     *
     * @param token
     * @param pubKeyPath
     * @return
     * @throws Exception
     */
    public static IJWTInfo getInfoFromToken(String token, String pubKeyPath) throws Exception {
        Jws<Claims> claimsJws = parserToken(token, pubKeyPath);
        Claims body = claimsJws.getBody();
        return new JWTInfo(body.getSubject()
                , StringHelper.getObjectValue(body.get(CommonConstants.JWT_KEY_USER_ID))
                , StringHelper.getObjectValue(body.get(CommonConstants.JWT_KEY_NAME)));
    }

}

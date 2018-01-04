//package com.springcloud.test;
//
//import com.springcloud.common.util.jwt.IJWTInfo;
//import com.springcloud.common.util.jwt.JWTInfo;
//import com.springcloud.zuul.util.JWTUtil;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jws;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import static org.junit.Assert.assertEquals;
//
///**
// * @Auther: James Wang
// * @Data: 2018/1/3 14:57
// */
//
//public class JWTUtileUniTest extends BaseUnitTest{
//    @Autowired
//    private JWTUtil util;
//    @Test
//    public void testJwt() throws Exception {
//        String username = "admin";
//        String userId = "1";
//        String name = "James";
//
//        String token = util.generateToken(new JWTInfo(username,userId,name));
//        IJWTInfo infoFromToken = util.getInfoFromToken(token);
//
//        assertEquals(infoFromToken.getUsername(),username);
//    }
//}

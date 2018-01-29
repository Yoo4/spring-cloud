package com.springcloud.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileOutputStream;
import java.io.IOException;


import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * @Auther: James Wang
 * @Data: 2018/1/3 15:01
 */

@RunWith(SpringRunner.class)
public class jwtTest {
    @Test
    public void generateKey() throws IOException,NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        SecureRandom secureRandom = new SecureRandom("pass".getBytes());
        keyPairGenerator.initialize(1024,secureRandom);
        KeyPair keyPair = keyPairGenerator.genKeyPair();

        String publicKeyFilename = "F:\\IdeaProjects\\cloud\\springcloud-learning\\service-zuul\\src\\test\\java\\resources\\pub.key";
        byte[] publicKeyBytes = keyPair.getPublic().getEncoded();
        FileOutputStream fos = new FileOutputStream(publicKeyFilename);
        fos.write(publicKeyBytes);
        fos.close();

        String privateKeyFilename = "F:\\IdeaProjects\\cloud\\springcloud-learning\\service-zuul\\src\\test\\java\\resources\\pri.key";
        byte[] privateKeyBytes = keyPair.getPrivate().getEncoded();
        fos = new FileOutputStream(privateKeyFilename);
        fos.write(privateKeyBytes);
        fos.close();
    }
}

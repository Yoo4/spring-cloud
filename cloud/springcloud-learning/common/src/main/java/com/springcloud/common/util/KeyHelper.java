package com.springcloud.common.util;

import java.io.*;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * @Auther: James Wang
 * @Data: 2018/1/3 16:15
 */

public class KeyHelper {
    /**
     * @Date: 2018/1/3 16:52
     * @Content: 获取公钥
     */
    public static PublicKey getPublicKey(String filename) throws Exception{
        File f = new File(filename);
        FileInputStream fis = new FileInputStream(f);
        DataInputStream dis = new DataInputStream(fis);
        byte[] keyBytes = new byte[(int)f.length()];
        dis.readFully(keyBytes);
        dis.close();
        X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePublic(spec);
    }

    /**
     * @Date: 2018/1/3 16:52
     * @Content: 获取密钥
     */
    public static PrivateKey getPrivateKey(String filename) throws Exception{
        File f = new File(filename);
        FileInputStream fis = new FileInputStream(f);
        DataInputStream dis = new DataInputStream(fis);
        byte[] keyBytes = new byte[(int)f.length()];
        dis.readFully(keyBytes);
        dis.close();
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePrivate(spec);
    }

    /**
     * 生产rsa公钥和密钥
     * @param publicKeyFilename
     * @param privateKeyFilename
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */

    public static void generateKey(String publicKeyFilename,String privateKeyFilename,String password) throws IOException,NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        SecureRandom secureRandom = new SecureRandom(password.getBytes());
        keyPairGenerator.initialize(1024,secureRandom);
        KeyPair keyPair = keyPairGenerator.genKeyPair();

        byte[] publicKeyBytes = keyPair.getPublic().getEncoded();
        FileOutputStream fos = new FileOutputStream(publicKeyFilename);
        fos.write(publicKeyBytes);
        fos.close();

        byte[] privateKeyBytes = keyPair.getPrivate().getEncoded();
        fos = new FileOutputStream(privateKeyFilename);
        fos.write(privateKeyBytes);
        fos.close();
    }

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        generateKey("F:\\IdeaProjects\\cloud\\springcloud-learning\\server-auth\\src\\main\\resources\\client\\pub.key",
                "F:\\IdeaProjects\\cloud\\springcloud-learning\\server-auth\\src\\main\\resources\\client\\pri.key"
                ,"learning");
    }
}
